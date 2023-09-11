package io.temporal.replaydemo.business.activities;

import io.temporal.activity.ActivityInterface;

import java.awt.*;

@ActivityInterface
public interface DemoOneActivities {
    void first();
    String second();
}
