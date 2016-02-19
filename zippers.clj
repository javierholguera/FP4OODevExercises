
(require '[clojure.zip :as zip])

;; exercise 1
(defn all-vectors [tree]
  (letfn [(flatten-zipper [so-far zipper]
            (cond
              (zip/end? zipper) (do (println zipper) so-far)
              (vector? (zip/node zipper)) (do (println zipper) (flatten-zipper (cons (zip/node zipper) so-far) (zip/next zipper)))
              :else (do (println zipper) (flatten-zipper so-far (zip/next zipper)))))]))


(comment
  (all-vectors '(fn [a b] (concat [a] [b])))   

)
