(ns magic-server.builders.cljs
  (:require [taoensso.timbre :as timbre]
            [clojurescript-build.core :as cljsb]
            [magic-server.globals :refer [dirs]]))

(defn build [args]
  (timbre/debug "cljs build started...")
  (let [{:keys [src-dir dist-dir dist-file main]} args
        dist-path (str (-> dirs :target :root-dir) dist-dir dist-file)]
    (cljsb/build-source-paths src-dir ; list source directories
      {:output-to dist-path
       :output-dir dist-dir
       :main main
       :source-map (str dist-dir dist-file ".map")
       :optimizations :advanced
       :elide-asserts true
       :verbose true
       :source-map-timestamp true
       :parallel-build true
       :pretty-print false})))
