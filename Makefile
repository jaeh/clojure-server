# build the html, css, js and nginx files
build:
	lein run

# run dev task using figwheel (not fully implemented yet)
dev:
	lein run -- :dev true

# build the docker container
docker-build:
	docker build -t magic-host .

# run the dockerfile on port 80:80,
# --rm removes the container on exit
docker-run:
	docker run \
	--name magic-server \
	 -p 80:80 \
	 -i -t \
	 --rm \
	 -v $(PWD)/resources/public:/www/data \
	 magic-host

docker-run-prod:
	docker run \
	--name magic-server \
	-p 80:80 \
	--rm \
	-v $(PWD)/resources/public:/www/data \
	magic-host

# removes ALL docker containers
rmContainers:
	docker rm $(shell docker ps -a -q)

# removes ALL docker images
rmImages:
	docker rmi $(shell docker images -q)

# main docker task, builds deps then runs the container
docker: build docker-build docker-run

# remove dist files
clean:
	rm resources target -r

dev: docker

# run production build (atm every build is a production build)
prod: build docker-build docker-run-prod

# build is the default task
all: build