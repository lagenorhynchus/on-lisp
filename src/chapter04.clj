(ns on-lisp.chapter04)

;;;; 4.1

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
        "Frederick" ["Fred," "Freddy"]
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
  {"A" ["a1" "a2" "a3"]
   "B" ["b1" "b2"]
   "C" ["c1" "c2" "c3" "c4"]})

;; FIXME
(let [town (some bookshops ["B"])]
  [town (bookshops town)])
