(ns magic-server.builders.garden
  (:import java.io.File)
  (:require [taoensso.timbre :as timbre]
            [garden.core :as garden]
            [magic-server.utils.core :refer [safe-spit]]
            [magic-server.globals :refer [dirs]]))

(defn build [style]
  "Uses garden to build the css and spit it to the resources dir"
  (timbre/debug "garden started...")
  (println style)
  (let [{:keys [content file]} style
        output-file (str (-> dirs :target :css) file)]

    (if (or content file output-file)
      (do
        (timbre/debug "spitting css to " output-file file)
        (safe-spit output-file (garden/css content))
      (timbre/error "css input or output-file not specified. Exiting")))))
