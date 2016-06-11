(ns chapter02)

;;;; 2.2

(defn double' [x]
  (* x 2))

(double' 1)

double'
#'double'

(= double' (first (list double')))
(= #'double' (first (list #'double')))

((fn [x] (* x 2)) 3)

(var-get #'double')

(def x concat)

(= (var-get #'x) (var-get #'concat))

(def double'' (fn [x] (* x 2)))

;;;; 2.3

(+ 1 2)
(apply + '(1 2))
(apply #'+ '(1 2))
(apply (var-get #'+) '(1 2))
(apply (fn [x y] (+ x y)) '(1 2))
(apply #(+ %1 %2) '(1 2))

(apply + 1 '(2))

(map (fn [x] (+ x 10))
     '(1 2 3))

(map +
     '(1 2 3)
     '(10 100 1000))

(sort < '(1 4 2 5 6 7 3))

(remove even? '(1 2 3 4 5 6 7))

(defn our-remove [f lst]
  (if (empty? lst)
    []
    (if (f (first lst))
      (our-remove f (rest lst))
      (cons (first lst) (our-remove f (rest lst))))))

;;;; 2.4

(defn behave [animal]
  (case animal
   :dog [:wag-tail
         :bark]
   :rat [:scurry
         :squeak]
   :cat [:rub-legs
         :scratch-carpet]))

(defmulti behave identity)
(defmethod behave :dog [_]
  [:wag-tail
   :bark])

;;;; 2.5

(let [y 7]
  (defn scope-test [x]
    (list x y)))
