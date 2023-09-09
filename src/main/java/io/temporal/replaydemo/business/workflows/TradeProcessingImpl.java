package io.temporal.replaydemo.business.workflows;

import io.temporal.activity.ActivityOptions;
import io.temporal.failure.ApplicationFailure;
import io.temporal.replaydemo.business.activities.ProcessingActivities;
import io.temporal.spring.boot.WorkflowImpl;
import io.temporal.workflow.Workflow;

import java.time.Duration;

@WorkflowImpl(taskQueues = "TradeQueue")
public class TradeProcessingImpl implements TradeProcessing {
    private ProcessingActivities activities =
            Workflow.newActivityStub(ProcessingActivities.class,
                    ActivityOptions.newBuilder()
                            .setStartToCloseTimeout(Duration.ofSeconds(5))
                            .build());
    @Override
    public String process() {
        activities.test();

        throw ApplicationFailure.newFailure("failing on purpose...", NullPointerException.class.getName(), "details");
//        return "done...";
    }
}
