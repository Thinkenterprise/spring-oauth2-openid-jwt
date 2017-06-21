package com.thinkenterprise;



import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "fortune")
public class FortuneProperties {

    private String fallbackFortune = "Your future is unclear.";

    public String getFallbackFortune() {
        return fallbackFortune;
    }

    public void setFallbackFortune(String fallbackFortune) {
        this.fallbackFortune = fallbackFortune;
    }

}
