package io.temporal.replaydemo.business.workflows;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface DemoTwoWorkflow {
    @WorkflowMethod
    public String runDemo(String input);
}
