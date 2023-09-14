package io.temporal.replaydemo.business.workflows;

import io.temporal.activity.ActivityOptions;
import io.temporal.common.RetryOptions;
import io.temporal.replaydemo.business.activities.DemoOneActivities;
import io.temporal.replaydemo.business.activities.DemoTwoActivities;
import io.temporal.spring.boot.WorkflowImpl;
import io.temporal.workflow.Async;
import io.temporal.workflow.Promise;
import io.temporal.workflow.Workflow;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@WorkflowImpl(taskQueues = "DemoTaskQueue")
public class DemoTwoWorkflowImpl implements DemoTwoWorkflow {

    private DemoTwoActivities activities =
            Workflow.newActivityStub(DemoTwoActivities.class,
                    ActivityOptions.newBuilder()
                            .setStartToCloseTimeout(Duration.ofSeconds(5))
                            .setRetryOptions(RetryOptions.newBuilder()
                                    .setBackoffCoefficient(1) // for demo
                                    .build())
                            .build());


    @Override
    public String runDemo(String input) {
        List<Promise<Void>> activityPromises = new ArrayList<>();
        for(int i=0;i<5;i++) {
            activityPromises.add(Async.procedure(activities::third, input));
            activityPromises.add(Async.procedure(activities::fourth, input));
        }

        for(Promise<Void> activityPromise : activityPromises) {
            activityPromise.get();
        }
        return "Workflow completed for " + input;
    }
}
