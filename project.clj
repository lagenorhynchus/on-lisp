(defproject on-lisp "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [proto-repl "0.1.2"]
                 [proto-repl-charts "0.2.0"]
                 [org.clojure/math.numeric-tower "0.0.4"]]
  :profiles {:dev {:source-paths ["src" "test"]
                   :dependencies [[org.clojure/tools.namespace "0.2.11"]]}})
