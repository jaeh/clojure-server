(ns magic-server.builders.nginx
  (:require [taoensso.timbre :as timbre]
            [clojure.java.io :refer [make-parents]]
            [hiccup.core :as hiccup]
            [hiccup.page :as hpage]
            [magic-server.utils.core :refer [safe-spit]]
            [magic-server.pages.wizardsatwork.globals :refer [hostname]]
            [magic-server.globals :refer [dirs nginx-config]]))

(defn copy-config []
  (timbre/debug "copy nginx.conf")
  (let [config-string (slurp (str (-> dirs :src :nginx) "nginx.conf"))]
    (safe-spit "resources/nginx/nginx.conf" config-string)
    (timbre/debug "copying of nginx.conf done")))

(defn replace-hostname [str]
  (clojure.string/replace str #"HOSTNAME" hostname))

(defn replace-routes [str routes]
  (clojure.string/replace str #"ROUTES" (fn [r] (clojure.string/join "\n" routes))))

(defn replace-config [file routes]
  (let [str (slurp file)
        hostnamed-config (replace-hostname str)]
    (replace-routes hostnamed-config routes)))

(defn gen-config [routes]
  (let [input-file (str (-> dirs :src :nginx) "sites-enabled/default")
        output-file  (str (-> dirs :target :nginx) "sites-enabled/" hostname)
        config (replace-config input-file routes)]
    (timbre/debug "writing to file " output-file)
    (safe-spit output-file config)))

(defn build [args]
  (timbre/debug "args" args)
  (let [{:keys [routes]} args]
    (println "nginx config generation started...")
    (copy-config)
    (gen-config routes)))