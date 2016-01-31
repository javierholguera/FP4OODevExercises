(ns )

(defn solution1 []
  (-> (concat '(a b c) '(d e f))
      ( (fn [coll]
          (-> (count coll)
              ( (fn [count]
                  (odd? count))))))))

(defn solution2 []
  (-> '(a b c)
      ( (fn [coll]
          (-> (concat coll '(d e f))
              ( (fn [coll]
                  (-> (count coll)
                      ( (fn [count]
                          (odd? count)))))))))))

(defn solution3 []
  (-> 3
      ( (fn [n]
          (-> (+ n 2)
              ( (fn [result]
                  (inc result))))))))
