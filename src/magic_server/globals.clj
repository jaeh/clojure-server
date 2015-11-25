(ns magic-server.globals)

(def root-dir "resources/")

(def dirs {:target {:html (str root-dir "public/")
                    :css (str "css/")
                    :nginx (str root-dir "nginx/")}
           :src {:nginx "src/magic_server/nginx/"}})

(def nginx-config "nginx.conf")