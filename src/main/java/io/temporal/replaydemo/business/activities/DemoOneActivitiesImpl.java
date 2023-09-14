package io.temporal.replaydemo.business.activities;

import io.temporal.spring.boot.ActivityImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

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
    public String second() {
        try {
            Resource resource = resourceLoader.getResource("classpath:/static/sample.jpg");
            InputStream resourceInputStream = resource.getInputStream();
//            return new BufferedReader(
//                    new InputStreamReader(resourceInputStream, StandardCharsets.UTF_8))
//                    .lines()
//                    .collect(Collectors.joining("\n"));
            return resource.getURL().toString();
        } catch (Exception e) {
            System.out.println("** Activity failure: " + e.getMessage());
            return null;
        }
    }
}
