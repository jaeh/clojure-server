(ns magic-server.builders.cljs-dev
  (:require [taoensso.timbre :as timbre]
            [figwheel-sidecar.repl :as r]
            [figwheel-sidecar.repl-api :as ra]))

(defn build [args]
  "Build the clojurescript sources to javascript and spit them to resources/public/js"
  (let [{:keys [src-dir dist-dir dist-file namespace]} args]
    (ra/start-figwheel!
      {:figwheel-options {}
       :build-ids ["dev"]
       :all-builds
       [{:id "dev"
         :figwheel true
         :source-paths [src-dir]
         :compiler {:main namespace
                    :asset-path "js"
                    :output-to (str dist-dir dist-file)
                    :output-dir dist-dir
                    :verbose true}}]}))
  (ra/cljs-repl))