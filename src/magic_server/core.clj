(ns magic-server.core
  (:require [taoensso.timbre :as timbre]
            [magic-server.pages.wizardsatwork.core :as wizardsatwork])
  (:gen-class))

(defn -main
  "gather files for build process and spit them into the resources dir"
  [& args]
  (wizardsatwork/build (not (empty? args)))
  (System/exit 0))