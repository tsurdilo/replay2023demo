package io.temporal.replaydemo;

import io.temporal.client.WorkflowClient;
import io.temporal.spring.boot.autoconfigure.properties.TemporalProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReplayDemoController {
    @Autowired
    TemporalProperties temporalProperties;

    @Autowired
    WorkflowClient workflowClient;

    @GetMapping("/workerinfo")
    public String update(Model model) {
        model.addAttribute("temporal", temporalProperties);
        model.addAttribute("client", workflowClient);
        return "workerinfo";
    }
}
