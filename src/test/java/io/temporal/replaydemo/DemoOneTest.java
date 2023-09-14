package io.temporal.replaydemo;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.replaydemo.business.workflows.DemoOneWorkflow;
import io.temporal.replaydemo.business.workflows.DemoOneWorkflowImpl;
import io.temporal.testing.TestWorkflowEnvironment;
import io.temporal.testing.WorkflowReplayer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest(classes = DemoOneTest.Configuration.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DemoOneTest {

    @Autowired
    ConfigurableApplicationContext applicationContext;

    @Autowired
    TestWorkflowEnvironment testWorkflowEnvironment;

    @Autowired
    WorkflowClient workflowClient;

    @BeforeEach
    void setUp() {
        applicationContext.start();
    }

    @ComponentScan
    public static class Configuration {}

    @Test
    public void demoOneTest() {

        DemoOneWorkflow workflow =
                workflowClient.newWorkflowStub(DemoOneWorkflow.class,
                        WorkflowOptions.newBuilder().setTaskQueue("DemoTaskQueue").build());

        String result = workflow.runDemo("test input");
        Assertions.assertEquals("Workflow completed for test input", result, "Invalid result.");
    }

    @Test
    public void demoOneReplayTest() {
        DemoOneWorkflow workflow =
                workflowClient.newWorkflowStub(DemoOneWorkflow.class,
                        WorkflowOptions.newBuilder()
                                .setWorkflowId("DemoOneTestId")
                                .setTaskQueue("DemoTaskQueue").build());

        String result = workflow.runDemo("test input");
        Assertions.assertEquals("Workflow completed for test input", result);

        try {
            WorkflowReplayer.replayWorkflowExecution(testWorkflowEnvironment.getWorkflowClient()
                            .fetchHistory("DemoOneTestId"),
                    DemoOneWorkflowImpl.class);
        } catch (Exception e) {
            Assertions.fail("Failure during replay: " + e.getMessage());
        }
    }
}
