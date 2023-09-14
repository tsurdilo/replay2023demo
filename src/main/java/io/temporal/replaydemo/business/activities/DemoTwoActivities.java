package io.temporal.replaydemo.business.activities;

import io.temporal.activity.ActivityInterface;

@ActivityInterface
public interface DemoTwoActivities {
    void third(String input);
    void fourth(String input);
}
