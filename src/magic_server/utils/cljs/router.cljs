(ns magic-server.utils.cljs.router)

(def toggleClassName "menu-toggled")

(defn listener
  [ele cb]
  (.addEventListener ; you have to support IE8 and lower? Bummer.
    ele "click"
    (cb)))

(defn init []
  (let [toggler (js/document.querySelector "div.toggle")
        menu-links (js/document.querySelectorAll "nav.main ul li a")]
    (js/console.log "toggler" toggler)
    (listener toggler #(fn [evt]
                        (js/document.body.classList.toggle toggleClassName)
                        (.preventDefault evt)))
    (for [link menu-links]
      (listener link #(fn [evt]
                       (when (> (js/document.body.className.indexOf toggleClassName) -1)
                         (js/document.body.classList.remove toggleClassName))
                       (.preventDefault evt))))))