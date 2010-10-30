(ns sudosolver.test.core
  (:use [sudosolver.core] :reload)
  (:use [clojure.test]))

(deftest valid?-accepts-correct-sets
    (is (valid? [0 0 0 0 0 0 0 0 0]))    
    (is (valid? [0 0 0 4 5 6 7 8 9]))
    (is (valid? [1 2 3 4 5 6 7 8 9])))
    
(deftest valid?-check-length 
    (is (not (valid? [1 2 3])))
    (is (not (valid? [1 2 3 4 5 6 7 8 9 0]))))
     
(deftest valid?-checks-each-element-between-1-and-9
    (is (not (valid? [1 10 3 4 5 6 7 8 9]))))
    
(deftest valid?-checks-no-duplicate
    (is (not (valid? [1 1 3 4 5 6 7 8 9]))))
    
(deftest check-candidate
    (is (= #{1}     (candidates [2 3 4 5 6 7 8 9])))
    (is (= #{1 2 3} (candidates [0 0 4 5 6 7 8 9])))
    (is (= #{2}     (candidates [0 0 4 5 6 7 8 9] 
                                [1 0 4 0 0 0 0 0]
                                [3 0 4 0 0 0 0 0]))))

 