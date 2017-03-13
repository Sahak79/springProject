package am.gch.usd.web.controller.user;

import am.gch.usd.common.data.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@PreAuthorize("hasRole('ROLE_USER')")
public class UserController {

    @RequestMapping("/user/home")
    public String homeUser(@AuthenticationPrincipal User user) {
        return "user/home";
    }
}
