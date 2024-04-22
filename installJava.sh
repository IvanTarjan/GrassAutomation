#!/bin/bash

#initial update
sudo apt update && sudo apt upgrade -y

# install unzip
sudo apt install unzip

# Chrome-For-Testing download link | version 123.0.6312.122
wget https://storage.googleapis.com/chrome-for-testing-public/123.0.6312.122/linux64/chrome-linux64.zip
# headless: wget https://storage.googleapis.com/chrome-for-testing-public/123.0.6312.122/linux64/chrome-headless-shell-linux64.zip
# Unzip
unzip chrome-linux64.zip
#headless unzip chrome-headless-shell-linux64.zip

# Cleanup
rm chrome-linux64.zip
#headless rm chrome-headless-shell-linux64.zip

# Download chromedriver
wget https://storage.googleapis.com/chrome-for-testing-public/123.0.6312.122/linux64/chromedriver-linux64.zip

unzip chromedriver-linux64.zip
mv chromedriver-linux64/chromedriver ./src/main/resources/chromedriver

# Cleanup
rm chromedriver-linux64.zip

# Install Java 18
sudo apt install -y default-jre 
sudo apt-get install -y openjdk-18-jdk

# verify java
java -version
javac -version

# Install Maven Apache
sudo apt install maven -y

# verify maven
mvn --version

