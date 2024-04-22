#!/bin/bash

#initial update
sudo apt -y update

# install unzip
sudo apt -y install unzip 

#download outside repo
cd ../
# Totally legal mirror to install google chrome ver. 123.0.6312.122
wget http://mirror.cs.uchicago.edu/google-chrome/pool/main/g/google-chrome-stable/google-chrome-stable_123.0.6312.122-1_amd64.deb

# install chrome
sudo dpkg -i google-chrome-stable_123.0.6312.122-1_amd64.deb

# Cleanup
sudo rm google-chrome-stable_123.0.6312.122-1_amd64.deb

#go back to repo
cd ./GrassAutomation

# Install Java 18

sudo apt-get -y install openjdk-18-jdk

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