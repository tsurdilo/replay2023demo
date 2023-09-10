package io.temporal.replaydemo.business.activities;

import io.temporal.activity.ActivityInterface;

import java.io.File;

@ActivityInterface
public interface DemoOneActivities {
    void first();
    File second();
}
