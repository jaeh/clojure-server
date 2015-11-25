(ns magic-server.builders.assets
  (:require [me.raynes.fs :as fs]))

(defn build [args]
  (let [{:keys [src-dir dist-dir]} args]
    (println "copying assets")
    (fs/copy-dir-into (str fs/*cwd* src-dir) (str fs/*cwd* dist-dir))))
