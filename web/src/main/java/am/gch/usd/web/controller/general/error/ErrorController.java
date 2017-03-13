package am.gch.usd.web.controller.general.error;

import am.gch.usd.web.interceptor.AdminRequired;
import am.gch.usd.web.interceptor.LoggingInterceptor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorController {

    @RequestMapping("/404")
    @AdminRequired
    public String resourceNotFound(HttpServletRequest request, Model model) {
        String resourceName = getResourceName(request);
        model.addAttribute("requestedResource", resourceName);
        return "/error/404";
    }

    @RequestMapping("/403")
    public String accessDenied(HttpServletRequest request, Model model) {
        String resourceName = getResourceName(request);
        model.addAttribute("requestedResource", resourceName);
        return "/error/403";
    }

    @RequestMapping("/500")
    public String internalServerError(HttpServletRequest request, Model model) {
        return "/error/500";
    }

    private String getResourceName(HttpServletRequest request) {
        return (String) request.getAttribute("javax.servlet.error.request_uri");
    }
}
