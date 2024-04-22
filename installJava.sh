#!/bin/bash

#Chrome-For-Testing download link | version 123.0.6312.122
wget https://storage.googleapis.com/chrome-for-testing-public/123.0.6312.122/linux64/chrome-linux64.zip
# headless version: https://storage.googleapis.com/chrome-for-testing-public/123.0.6312.122/linux64/chrome-headless-shell-linux64.zip

# Unzip
unzip chrome-linux64.zip

# Cleanup
rm chrome-linux64.zip


# Install Java 17
sudo apt-get update
sudo apt install default-jre
sudo apt-get install -y openjdk-17-jdk

