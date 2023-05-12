package com.springconfigclient.microservieone;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("eybis.kafka")
@org.springframework.context.annotation.Configuration
public class KafkaConfigurationExample {
    private String ip;
    private int port;
    private String contentCompleteDataTopic;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getContentCompleteDataTopic() {
        return contentCompleteDataTopic;
    }

    public void setContentCompleteDataTopic(String contentCompleteDataTopic) {
        this.contentCompleteDataTopic = contentCompleteDataTopic;
    }
}
