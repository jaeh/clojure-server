(ns magic-server.utils.core
  (:require [clojure.java.io :refer [make-parents]]))

(defn safe-spit [file content]
  (make-parents file)
  (spit file content))

(defn ln [s]
  (str s "\n"))
