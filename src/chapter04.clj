(ns on-lisp.chapter04)

;;;; 4. Utility Functions

;;; 4.1 Birth of a Utility

(defn nicknames [n]
  (get {"Albert" ["Al"]
        "Andrew" ["Andy"]
        "Anthony" ["Tony"]
        "Arthur" ["Art" "Arty"]
        "Bernard" ["Bernie" "Bern"]
        "Charles" ["Charlie" "Chuck"]
        "Christopher" ["Chris"]
        "Daniel" ["Dan" "Danny"]
        "Donald" ["Don"]
        "Edward" ["Ed" "Eddie"]
        "Eugene" ["Gene"]
        "Francis" ["Frank" "Fran"]
        "Frederick" ["Fred" "Freddy"]
        "Henry" ["Hank"]
        "Irving" ["Irv"]
        "James" ["Jim" "Jimmy"]
        "Joseph" ["Joe"]
        "John" ["Jack" "Jacky"]
        "Lawrence" ["Larry"]
        "Leonard" ["Leo"]}
       n
       []))

(defn all-nicknames [names]
  (if (empty? names)
    []
    (concat (nicknames (first names))
            (all-nicknames (rest names)))))

(defn all-nicknames' [names]
  (mapcat nicknames names))

(def bookshops
  {"London" ["L1" "L2" "L3"]
   "Paris" ["P1" "P2"]
   "Berlin" ["B1" "B2" "B3" "B4"]})

(defn find-books [towns]
  (if (empty? towns)
    nil
    (if-let [shops (bookshops (first towns))]
      [(first towns) shops]
      (recur (rest towns)))))

(defn find2 [f coll]
  (if (empty? coll)
    nil
    (if-let [v (f (first coll))]
      [(first coll) v]
      (recur f (rest coll)))))

(defn find-books' [towns]
  (find2 bookshops towns))

;;; 4.3 Operations on Lists
