package io.temporal.replaydemo.business.activities;

import io.temporal.spring.boot.ActivityImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.File;

@Component("DemoOneActivities")
@ActivityImpl(taskQueues = "DemoTaskQueue")
public class DemoOneActivitiesImpl implements DemoOneActivities {

    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public void first() {
        try {
            Thread.sleep(2 * 1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public File second() {
        try {
        Resource resource = resourceLoader.getResource("classpath:sample.jpg");
        File file = resource.getFile();
        return file;
        } catch (Exception e) {
            System.out.println("** Activity failure: " + e.getMessage());
            return null;
        }
    }
}
