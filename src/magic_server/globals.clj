(ns magic-server.globals)

(def hostname "localhost")

(def root-dir "resources/public/")

(def dirs {:target {:html root-dir
                    :css (str root-dir "css/")
                    :nginx "resources/nginx/"}
           :src {:nginx "src/magic_server/nginx/"}})

(def nginx-config "nginx.conf")