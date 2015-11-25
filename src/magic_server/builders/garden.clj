(ns magic-server.builders.garden
  (:import java.io.File)
  (:require [taoensso.timbre :as timbre]
            [garden.core :as garden]
            [magic-server.utils.core :refer [safe-spit]]
            [magic-server.globals :refer [root-dir]]))

(defn build [style]
  "Uses garden to build the css and spit it to the resources dir"
  (timbre/debug "garden started...")
  (let [{:keys [content src-file]} style
        output-file (str root-dir src-file)]
    (timbre/debug "spitting css to " output-file)
    (safe-spit output-file (garden/css content))))