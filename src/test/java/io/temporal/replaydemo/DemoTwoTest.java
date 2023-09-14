package io.temporal.replaydemo;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.replaydemo.business.workflows.DemoOneWorkflow;
import io.temporal.replaydemo.business.workflows.DemoTwoWorkflow;
import io.temporal.testing.TestWorkflowEnvironment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest(classes = DemoOneTest.Configuration.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DemoTwoTest {

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
    public void demoTwoTest() {

        DemoTwoWorkflow workflow =
                workflowClient.newWorkflowStub(DemoTwoWorkflow.class,
                        WorkflowOptions.newBuilder().setTaskQueue("DemoTaskQueue").build());

        workflow.runDemo("test input");
    }

}
