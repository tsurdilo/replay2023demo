package io.temporal.replaydemo.business.activities;

import io.temporal.spring.boot.ActivityImpl;
import org.springframework.stereotype.Component;

@Component("DemoTwoActivities")
@ActivityImpl(taskQueues = "DemoTaskQueue")
public class DemoTwoActivitiesImpl implements DemoTwoActivities {
    @Override
    public void third(String input) {
        try {
            Thread.sleep(1 * 1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void fourth(String input) {
        try {
            Thread.sleep(2 * 1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
