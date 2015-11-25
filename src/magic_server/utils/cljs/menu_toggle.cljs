(ns magic-server.utils.cljs.menu-toggle)

(def toggleClassName "menu-toggled")

(defn nodelist-to-seq
  "Converts nodelist to (not lazy) seq."
  [nl]
  (let [result-seq (map #(.item nl %) (range (.-length nl)))]
    (js/console.log "result-seq" result-seq)
    (doall result-seq)))

(defn init []
  (let [parent (.querySelector js/document "header.main")
        toggler (.querySelector parent "div.toggle")
        menu-ul (.querySelector parent "nav.main ul")]

    (.addEventListener
      menu-ul
      "click"
      (fn [evt]
        (js/document.body.classList.remove toggleClassName)
        (js/console.log "link clicked")))

    (.addEventListener
      toggler
      "click"
      (fn [evt]
        (js/document.body.classList.toggle toggleClassName)
        (.preventDefault evt)))))