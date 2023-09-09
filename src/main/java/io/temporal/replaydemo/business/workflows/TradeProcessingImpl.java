package io.temporal.replaydemo.business.workflows;

import io.temporal.spring.boot.WorkflowImpl;

@WorkflowImpl(taskQueues = "TradeQueue")
public class TradeProcessingImpl implements TradeProcessing {
    @Override
    public String process() {
        return "done...";
    }
}
