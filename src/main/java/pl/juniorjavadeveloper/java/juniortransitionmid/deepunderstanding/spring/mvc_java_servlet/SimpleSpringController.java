package pl.juniorjavadeveloper.java.juniortransitionmid.deepunderstanding.spring.mvc_java_servlet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/dashboard/simple/spring")
public class SimpleSpringController {
    @GetMapping
    public String dashboardView(String dashboardMode, Model model) {
        if (dashboardMode != null) {
            model.addAttribute("mode", dashboardMode);
        }
        return "dashboard.html";
    }
}
