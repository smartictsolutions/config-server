package com.springconfigclient.microservieone;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
import java.net.URI;

@ConfigurationProperties("microservice-one")
@org.springframework.context.annotation.Configuration
public class GeneralSpringConfiguration implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {
    private String driverClassName;
    private String url;
    private String username;
    private String password;
    private int port;

	public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        factory.setPort(this.getPort());
    }

    private String decyript()  {
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.TEXT_PLAIN);
            RestTemplate restTemplate = new RestTemplate();
            URI uri = new URI("http://localhost:" + 7030 + "/decrypt");

            ResponseEntity<String> result= restTemplate.postForEntity(uri,this.getPassword(),String.class);
            return result.getBody();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(this.getDriverClassName());
        dataSourceBuilder.url(this.getUrl());
        dataSourceBuilder.username(this.getUsername());
        dataSourceBuilder.password(this.decyript());
        return dataSourceBuilder.build();
    }

    private void configurationProperties(){
        System.err.println("Configuration için değerler===" + this.getPassword()+"/n" + this.getDriverClassName()+"/n"+ this.getUrl()+"/n"  );
    }



}