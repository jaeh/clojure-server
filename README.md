# magic-server

to build:
```
# build static files and nginx config
make build

# build a docker container that runs nginx
make docker
```

This application builds:

* html using hiccup
* css using garden
* js using clojurescript
* nginx config
* dockerfile

For detailed usage information see the Makefile
