package io.temporal.replaydemo.business.workflows;

import io.temporal.activity.ActivityOptions;
import io.temporal.replaydemo.business.activities.DemoOneActivities;
import io.temporal.spring.boot.WorkflowImpl;
import io.temporal.workflow.Workflow;

import java.time.Duration;

@WorkflowImpl(taskQueues = "DemoTaskQueue")
public class DemoOneWorkflowImpl implements DemoOneWorkflow {
    private DemoOneActivities activities =
            Workflow.newActivityStub(DemoOneActivities.class,
                    ActivityOptions.newBuilder()
                            .setStartToCloseTimeout(Duration.ofSeconds(5))
                            .build());

    @Override
    public String runDemo(String input) {
        activities.first();
        activities.second();
        return "Workflow completed for " + input;
    }
}
