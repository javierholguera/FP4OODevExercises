
;; exercise 1
(map (comp inc inc) [1 2 3])

;; exercise 2
(defn separate [pred seq]
  ( (juxt filter remove) pred seq))

;; exercise 5
(def my-atom (atom 0))
(swap! my-atom (fn [_] 33))
(deref my-atom)

;; exercise 6
(defn always [cons]
  (fn [& args] cons))
( (always 8) 1 'a :foo)

