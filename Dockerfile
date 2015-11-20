############################################################
# Dockerfile to build Nginx Installed Containers
# Based on Ubuntu
############################################################

# Set the base image to Ubuntu
FROM ubuntu

# File Author / Maintainer
MAINTAINER Jascha Ehrenreich


RUN apt-get install software-properties-common -y

# Install Nginx.
RUN \
  add-apt-repository -y ppa:nginx/stable && \
  apt-get update && \
  apt-get install -y nginx && \
  rm -rf /var/lib/apt/lists/* && \
  chown -R www-data:www-data /var/lib/nginx

# Remove the default Nginx configuration file
RUN rm -v /etc/nginx/nginx.conf

# Copy the config
ADD resources/nginx/nginx.conf /etc/nginx/

RUN rm /etc/nginx/sites-enabled/*

ADD resources/nginx/sites-enabled/* /etc/nginx/sites-enabled/

RUN ls /etc/nginx

RUN ls /etc/nginx/sites-enabled

RUN cat /etc/nginx/sites-enabled/localhost

ADD resources/public/ /www/data/

# Expose ports
EXPOSE 80 443

RUN nginx -t

# Set the default command to execute
# when creating a new container
CMD service nginx start