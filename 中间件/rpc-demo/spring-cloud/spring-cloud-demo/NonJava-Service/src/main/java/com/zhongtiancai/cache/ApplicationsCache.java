package com.zhongtiancai.cache;

import org.springframework.stereotype.Component;

import com.zhongtiancai.eureka.entity.Applications;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by pktczwd on 2016/11/25.
 */
@Component
public class ApplicationsCache {

    private AtomicReference<Applications> applicationsAtomicReference = new AtomicReference<>();

    public Applications getApplications() {
        return applicationsAtomicReference.get();
    }

    public void setApplications(Applications applications) {
        this.applicationsAtomicReference.set(applications);
    }
}
