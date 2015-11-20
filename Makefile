build:
	lein run

docker-build:
	docker build -t magic-host .

docker-run:
	docker run --name magic-server -p 80:80 -i -t magic-host

rmContainers:
	docker rm $(shell docker ps -a -q)

rmImages:
	docker rmi $(shell docker images -q)

docker: docker-build docker-run

clean:
	rm resources target -r

prod: docker-build docker-run

all: build