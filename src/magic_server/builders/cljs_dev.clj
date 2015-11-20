(ns magic-server.builders.cljs-dev
  (:require [taoensso.timbre :as timbre]
            [figwheel-sidecar.repl :as r]
            [figwheel-sidecar.repl-api :as ra]))

(defn build []
  "Build the clojurescript sources to javascript and spit them to resources/public/js"
  (ra/start-figwheel!
    {:figwheel-options {}
     :build-ids ["dev"]
     :all-builds
     [{:id "dev"
       :figwheel true
       :source-paths ["src/magic_server/cljs/"]
       :compiler {:main 'magic-server.cljs.core
                  :asset-path "js"
                  :output-to "resources/public/js/main.js"
                  :output-dir "resources/public/js"
                  :verbose true}}
      {:id "prod"
        :figwheel true
        :source-paths ["src/magic_server/cljs/"]
        :compiler {:main 'magic-server.cljs.core
                   :asset-path "js"
                   :output-to "resources/public/js/main.js"
                   :output-dir "resources/public/js"
                   :verbose true}}]})
  (ra/cljs-repl))