package com.zhongtiancai.ratelimit;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by pktczwd on 2016/10/31.
 */
@Data
@ConfigurationProperties("zuul.ratelimit")
public class RateLimitProperties {

    private Map<String, Policy> policies = new LinkedHashMap<>();
    private boolean enabled;
    private String type = "local";
	public Map<String, Policy> getPolicies() {
		return policies;
	}
	public void setPolicies(Map<String, Policy> policies) {
		this.policies = policies;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
    
    

}
