package com.springconfigclient.microservieone;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("eybis")
@org.springframework.context.annotation.Configuration
public class OtherConfiguration {

    private Boolean shutdownAfterLoad;
    private Boolean isTestEnv;


    public Boolean getShutdownAfterLoad() {
        return shutdownAfterLoad;
    }

    public void setShutdownAfterLoad(Boolean shutdownAfterLoad) {
        this.shutdownAfterLoad = shutdownAfterLoad;
    }

    public Boolean getIsTestEnv() {
        return isTestEnv;
    }

    public void setIsTestEnv(Boolean isTestEnv) {
        this.isTestEnv = isTestEnv;
    }


}
