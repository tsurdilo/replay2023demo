package io.temporal.replaydemo;

import io.temporal.replaydemo.business.model.RegisteredResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReplayDemoController {
    @Autowired
    RegisteredResourceRepository resourceRepository;

    @GetMapping("/resources")
    public String update(Model model) {
        model.addAttribute("resources", resourceRepository.findAll());
        return "resources";
    }

}
