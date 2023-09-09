package io.temporal.replaydemo.business.workflows;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface TradeProcessing {
    @WorkflowMethod
    String process();
}
