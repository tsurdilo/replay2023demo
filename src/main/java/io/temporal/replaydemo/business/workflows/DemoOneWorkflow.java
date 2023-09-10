package io.temporal.replaydemo.business.workflows;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface DemoOneWorkflow {
    @WorkflowMethod
    public String runDemo(String input);
}
