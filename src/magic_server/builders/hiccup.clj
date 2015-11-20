(ns magic-server.builders.hiccup
  (:require [taoensso.timbre :as timbre]
            [clojure.java.io :refer [make-parents]]
            [hiccup.core :as hiccup]
            [hiccup.page :as hpage]
            [magic-server.utils.core :refer [safe-spit]]
            [magic-server.globals :refer [dirs]]))

(defn build [page]
  (timbre/debug "hiccup started...")
  (let [{:keys [content file]} page
        output-file (str (-> dirs :target :html) file)]

    (if-not (or file content output-file)
      (timbre/error "html input or output-file not specified in page:" page " Exiting")
      (do
        (timbre/debug "spitting html to " output-file)
        (safe-spit output-file (hpage/html5 content))))))