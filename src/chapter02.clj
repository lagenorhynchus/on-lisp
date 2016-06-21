(ns chapter02)

;;;; 2.2

(defn double' [x]
  (* x 2))

(double' 1)

double'
#'double'

(identical? double' (first (list double')))
(identical? #'double' (first (list #'double')))

((fn [x] (* x 2)) 3)

double'
(var-get #'double')

(def x concat)
(identical? x concat)
(identical? (var-get #'x) (var-get #'concat))

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

(defn our-remove-if [f lst]
  (if (empty? lst)
    []
    (if (f (first lst))
      (our-remove-if f (rest lst))
      (cons (first lst) (our-remove-if f (rest lst))))))

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

(let [y 5]
  (scope-test 3))

;;;; 2.6

(defn list+ [lst n]
  (map (fn [x] (+ x n))
       lst))

(list+ '(1 2 3) 10)

(let [counter (atom 0)]
  (defn new-id []
    (swap! counter inc))
  (defn reset-id []
    (reset! counter 0)))

(defn make-adder [n]
  (fn [x] (+ x n)))

(def add2 (make-adder 2))
(def add10 (make-adder 10))
(add2 5)
(add10 3)

(defn make-adderb [n]
  (let [n (atom n)]
    (fn [x & [change?]]
      (if change?
        (reset! n x)
        (+ x @n)))))

(def addx (make-adderb 1))
(addx 3)
(addx 100 true)
(addx 3)

(defn make-dbms [db]
  (let [db (atom db)]
    (list
      (fn [key]
       (@db key))
      (fn [key val]
        (swap! db assoc key val)
        key)
      (fn [key]
        (swap! db dissoc key)
        key))))

(def cities (make-dbms {:boston :us :paris :france}))
((first cities) :boston)
((second cities) :london :england)
((first cities) :london)

(defn lookup [key db]
  ((first db) key))

;;;; 2.7

(map (fn [x] (+ 2 x))
     '(2 5 7 3))

(defn list+ [lst n]
  (map (fn [x] (+ x n))
       lst))

(letfn [(inc' [x] (inc x))]
  (inc' 3))

(defn count-instances [obj lsts]
  (letfn [(instances-in [lst]
            (if (seq lst)
              (+ (if (identical? (first lst) obj) 1 0)
                 (instances-in (rest lst)))
              0))]
    (map instances-in lsts)))

(count-instances :a '((:a :b :c) (:d :a :r :p :a) (:d :a :r) (:a :a)))

;;;; 2.8

(defn our-length [lst]
  (if (empty? lst)
    0
    (inc (our-length (rest lst)))))

(defn our-find-if [f lst]
  (if (f (first lst))
    (first lst)
    (recur f (rest lst))))

(defn our-length' [lst]
  (letfn [(rec [lst acc]
           (if (empty? lst)
             acc
             (recur (rest lst) (inc acc))))]
    (rec lst 0)))

(defn triangle [n]
  (letfn [(tri [c n]
            (if (zero? n)
              c
              (recur (+ n c) (dec n))))]
    (tri 0 n)))
