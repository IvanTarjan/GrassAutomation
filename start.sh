#!/bin/bash

#initial update
sudo apt update && sudo apt upgrade -y

# install unzip
sudo apt install unzip

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
sudo apt install -y default-jre 
sudo apt-get install -y openjdk-18-jdk

# verify java 
java -version
# verify javac
javac -version

# Install Maven Apache
sudo apt install maven -y

# verify maven
mvn --version

# Compile
mvn package -f pom.xml

# Run
java -jar ./target/Template-0.0.1-SNAPSHOT.jar $USERNAME $PASS