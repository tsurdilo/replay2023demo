package io.temporal.replaydemo.business.activities;

import io.temporal.spring.boot.ActivityImpl;
import org.springframework.stereotype.Component;

@Component("ProcessingActivities")
@ActivityImpl(taskQueues = "TradeQueue")
public class ProcessingActivitiesImpl implements ProcessingActivities {
    @Override
    public void test() {
        try {
            Thread.sleep(2 * 1000);
        } catch (Exception e) {

        }
    }
}
