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

  ;[4 1 3 7 5 8 2 6 9]
  ;[8 2 6 4 3 9 7 5 1]
  ;[7 5 9 6 1 2 8 4 3]
  ;[1 3 2 5 8 4 6 9 7]
  ;[5 8 7 3 9 6 4 1 2]
  ;[6 9 4 2 7 1 5 3 8]
  ;[3 7 8 1 6 5 9 2 4]
  ;[2 6 1 9 4 7 3 8 5]
  ;[9 4 5 8 2 3 1 7 6]
 
(def sudo1   
   [[0 1 3 7 5 8 2 6 9]
    [8 2 6 4 0 9 7 5 1]
    [7 5 9 6 1 2 8 4 3]
    [1 3 2 5 8 4 6 9 7]
    [5 8 7 3 9 6 4 1 2]
    [6 9 4 2 7 1 5 3 8]
    [3 7 8 1 6 5 9 2 4]
    [2 6 1 9 4 7 3 8 5]
    [9 4 5 8 2 3 1 7 6]])
 
(deftest check-extract-empties
    (is (= [[0 0] [4 1]] (extract-empties sudo1))))