(require '[clojure.algo.monads :refer :all])

(def decider
  (fn [step-value continuation]
    (if (nil? step-value)
      nil
      (continuation step-value))))

(def maybe-monad
  (monad [m-result identity
          m-bind decider]))

(def oops!
  (fn [reason & args]
    (with-meta (merge {:reason reason}
                      (apply hash-map args))
      {:type :error})))

(def oppsie?
  (fn [value]
    (= (type value) :error)))


(defn error-detector [step-value continuation]
  (if (oppsie? step-value)
    step-value
    (continuation step-value)))

(def error-monad
  (monad [m-result identity
          m-bind error-detector]))

(defn factorial [n]
  (cond
    (< n 0) (oops! "Factorial can never be less than zero." :number n)
    (< n 2) 1
    :else (* n (factorial (dec n)))))

(def result
  (with-monad error-monad
    (domonad [big-number (factorial -1)
              even-bigger (* 2 big-number)]
             (repeat :a even-bigger))))
