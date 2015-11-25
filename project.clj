(defproject magic-server "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://github.com/magic/server"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [com.taoensso/timbre "3.1.6"]
                 [filevents "0.1.0"]
                 [hiccup "1.0.5"]
                 [garden "1.3.0-SNAPSHOT"]
                 [me.raynes/fs "1.4.6"]
                 [figwheel-sidecar "0.4.1" :scope "provided"]]

  :main magic-server.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}

  :cljsbuild { :builds [{:id "min"
                         :source-paths ["src"]

                         :compiler {:output-to "resources/public/js/main.js"
                                    :main magic-server.cljs.core
                                    :optimizations :advanced
                                    :pretty-print false}}]})