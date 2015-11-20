(ns magic-server.core
  (:import java.io.File)
  (:require [taoensso.timbre :as timbre]
            [magic-server.builders.hiccup :as hiccup]
            [magic-server.builders.garden :as garden]
            [magic-server.builders.nginx :as nginx]
            [magic-server.builders.cljs-dev :as cljs-dev]
            [magic-server.builders.assets :as assets]
            [magic-server.html.index :as page-index]
            [magic-server.css.main :as css-main])
  (:gen-class))

(defn -main
  "gather files for build process and spit them into the resources dir"
  [& args]

  (mapv hiccup/build [{:content page-index/content
                       :file "index.html"}])

  (mapv garden/build [{:content css-main/style
                        :file css-main/file}])

  (cljs-dev/build)

  (nginx/build {:file "localhost"
                :routes [page-index/routes]})

  (assets/build)

  (System/exit 0))