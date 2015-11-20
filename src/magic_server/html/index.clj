(ns magic-server.html.index
  (:require [magic-server.html.head :as head]))

(defn ln [s]
  (str s "\n"))

(def routes
  (str
    (ln "  location ~* ^/(about|contact) {")
    (ln "    try_files $uri /index.html;")
    (ln "  }")
    (ln "  location = / {")
    (ln "    try_files $uri =404;")
    (ln "  }")
    (ln "  error_page 404 /index.html;")))

(def content (conj
               (head/html {:title "test title"
                           :description "test page index"})
               [:body
                [:div "testing"]
                [:script {:src "/js/main.js"}]]))