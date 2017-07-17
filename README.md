# Java based UDP Server and Client
Java Docker UDP Server and Client For K8S testing

## Introduction
Port 4445 is exposed and must be used via UDP only. When used, server will echo the response back and prints out client sent message to STDOUT. 
Trivial application designed to test network connectivity with K8S Ingress UDP.

## How to use?
You must launch Server first

### Launch Test Server
docker run -it -p 4445:4445/udp --name udp-test-server danielyinanc/udp-server-docker

### Launch Test Client
java -jar client/build/libs/client.jar

### What to expect?
You should see "test test" replicated across your docker console output. Same for kubernetes, you will see it on your console log. Client application is designed to test it locally, you need to modify java to make it work for your Ingress deployment.


## Development Roadmap

1. Make Client more configurable such as hostname, ip
2. Make Client accept bounced back UDP packages to ensure docker udp server sent packages survive network ingress