package com.zhongtiancai.ratelimit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pktczwd on 2016/10/31.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Policy {

    private Long refreshInterval = 60L;//seconds
    private Long limit;
    private List<Type> type = new ArrayList<>();
    
    

    public Long getRefreshInterval() {
		return refreshInterval;
	}



	public void setRefreshInterval(Long refreshInterval) {
		this.refreshInterval = refreshInterval;
	}



	public Long getLimit() {
		return limit;
	}



	public void setLimit(Long limit) {
		this.limit = limit;
	}



	public List<Type> getType() {
		return type;
	}



	public void setType(List<Type> type) {
		this.type = type;
	}



	public enum Type {
        ORIGIN, USER
    }
}
