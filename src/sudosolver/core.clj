(ns sudosolver.core
    (:use clojure.set))

(defn no-duplicate? [coll]
    (= (count coll) (count (distinct coll))))

(defn valid? [cells]
    (and
        (= 9 (count cells))
        (no-duplicate? (remove #(= 0 %) cells))
        (every? #(<= 0 % 9) cells)))

(defn candidates
    ([coll] (difference #{1 2 3 4 5 6 7 8 9} (set coll)))
    ([col1 col2 col3]
        (intersection   (candidates col1) 
                        (candidates col2) 
                        (candidates col3))))
