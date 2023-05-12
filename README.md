# Config Client

Config Client is a 

### Project Info

It is a Gradle-Spring Framework project that has Rest endpoint.

## Usage

### Configuration

##### Docker-Compose Configuration

This service has own configurations that based on Gmail. Also another mail configurations accepted. For the adjustments *Environment Variables* can be set for your container that like below on the docker-compose file

```
version: '3.9'
services: 
 config-server-app:
    container_name: config-server-container
    image: config-server-app-image
    restart: always
    ports:
      - "7030:7030"
    volumes:
      - ./config-server-configuration/config-server-app-config.yml:/config-server-configuration/config-server-app-config.yml
      - ./applications-configuration:/applications-configuration
    logging:
      driver: "json-file"
      options:
        max-size: "100m"
        max-file: "10"
    networks:
      config-server-net:
        ipv4_address: 182.24.0.2
        
networks:
  config-server-net:
    name: config-server-net
    ipam:
      driver: default
      config:
        - subnet: 182.24.0.0/16
          gateway: 182.24.0.1
```

Our service mainly considers Enviromental Variables for config configurations. If these entries does not set,





##### Application YAML Based Configuration

The other way of the setup mail configuration is editing application's own configuration file. This file must defined in the docker compose file as a volume that mentioned at the previous section. As you can see below, **config-client.YAML** file must placed the right place.

      - ```
    microservice-one:
      driver-class-name: org.postgresql.Driver
      url: jdbc:postgresql://localhost:5436/TEST_DB
      username: test_user
      password: e4ec47a252f0181f3a2f9355024731e4988053c1321cf9d17e424c2fd1aef429
      port: 8088
    
    eybis:
      shutdown-after-load: false
      is-test-env: false
      skip-ws-connect: false
      hazelcast:
        cluster-address:
    
       152.24.0.15:5701
       kafka:
            ip: 152.24.0.9
            port: 9093
            contentUserDataTopic: contentUserData
            contentCompleteDataTopic: contentCompleteData
            subjectContentTopic: subjectContent
            contentCompletePointsModificationTopic: contentCompletePointsModification
            numberOfTopicPartition: 1
            numberOfTopicReplication: 1
    ```
    
    







