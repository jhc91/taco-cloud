package controller.simple;

import framework.config.WebConfig;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 职责单一的视图控制器, 使用视图控制器替代 HomeController
 * @see WebConfig
 */
//@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }
}