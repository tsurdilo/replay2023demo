package io.temporal.replaydemo.business.activities;

import io.temporal.spring.boot.ActivityImpl;
import org.springframework.stereotype.Component;

@Component("DemoTwoActivities")
@ActivityImpl(taskQueues = "DemoTaskQueue")
public class DemoTwoActivitiesImpl implements DemoTwoActivities {
    @Override
    public void third(String input) {

    }

    @Override
    public void fourth(String input) {

    }
}
