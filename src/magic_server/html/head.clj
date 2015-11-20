(ns magic-server.html.head)

(defn html [args]
  (let [{:keys [title description]} args]
    [:head
     [:meta {:charset "utf-8"}]
     [:title title]
     [:meta {:type "description" :value description}]]))