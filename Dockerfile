FROM ubuntu:22.04

RUN apt update -y

WORKDIR app
COPY . /app/
RUN apt install -y wget unzip
RUN apt update -y
WORKDIR app
COPY . /app/
RUN apt install -y wget unzip

ARG DEBIAN_FRONTEND=noninteractive

##Install the pre requisites first to install chrome
RUN apt-get install -y tzdata
RUN apt-get install -y libappindicator1 fonts-liberation
RUN apt-get -y install libcurl4 lsb-release xdg-utils
RUN apt-get -y install libasound2 lsb-release xdg-utils
RUN apt-get -y install libgbm1 lsb-release xdg-utils
RUN apt-get -y install libnspr4 lsb-release xdg-utils
RUN apt-get -y install libnss3 lsb-release xdg-utils
RUN apt-get -y install dbus-x11 xfonts-base xfonts-100dpi xfonts-75dpi xfonts-cyrillic xfonts-scalable

##Install chrome
RUN wget -q https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
RUN dpkg -i google-chrome-stable_current_amd64.deb
RUN apt -f install -y
RUN apt-get update

##Install java and mvn
RUN apt-get install -y --no-install-recommends openjdk-18-jdk
RUN apt-get install -y --no-install-recommends maven

##Install git
RUN apt-get install -y --no-install-recommends git

## clone the project
RUN git clone https://github.com/serhatozdursun/assignment.of.payflow.git --branch master

##run project
RUN cd assignment.of.payflow.git &&\
    mvn test