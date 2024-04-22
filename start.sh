#!/bin/bash

#initial update
sudo apt -y update

# install unzip
sudo apt -y install unzip

cd ../
# Totally legal mirror to install google chrome ver. 123.0.6312.122
wget http://mirror.cs.uchicago.edu/google-chrome/pool/main/g/google-chrome-stable/google-chrome-stable_123.0.6312.122-1_amd64.deb

# install chrome
sudo dpkg -i google-chrome-stable_123.0.6312.122-1_amd64.deb

# Cleanup
sudo rm google-chrome-stable_123.0.6312.122-1_amd64.deb

cd ./GrassAutomation

# Install Java 21 with JRE
sudo apt-cache search openjdk
sudo apt -y install default-jre
sudo apt-get -y install openjdk-21-jdk
apt --fix-broken install

# verify java 
java -version
# verify javac
javac -version

# Install Maven Apache
sudo apt -y install maven

# verify maven
mvn --version

# Compile
mvn package -f pom.xml

# Run
java -jar ./target/Template-0.0.1-SNAPSHOT.jar $USERNAME $PASS