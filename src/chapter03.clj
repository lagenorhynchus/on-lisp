(ns on-lisp.chapter03
  (:require [clojure.math.numeric-tower :refer [expt]]))

;;;; 3. Functional Programming

;;; 3.1 Functional Design

(defn good-reverse [lst]
  (letfn [(rev [lst acc]
            (if (empty? lst)
              acc
              (recur (rest lst) (cons (first lst) acc))))]
    (rev lst ())))

;;; 3.2 Imperative Outside-In

(defn fun [x]
  (list :a (expt (first x) 2)))

(defn imp [x]
  (let [y (first x)
        sqr (expt y 2)]
    (list :a sqr)))
