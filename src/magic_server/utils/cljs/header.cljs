(ns magic-server.utils.cljs.header)

(def scrolledClass "scrolled")

(def header (js/document.querySelector "header.main"))

(defn resizeHeader
  []
  (let [scrollDiff (- (.-scrollY js/window) (+ (.-offsetTop header) (.-clientHeight header)))]
    (if (> scrollDiff -1)
      (js/document.body.classList.add scrolledClass)
      (js/document.body.classList.remove scrolledClass))))

(defn init
  []
  (js/window.addEventListener "scroll" resizeHeader)
  (resizeHeader))