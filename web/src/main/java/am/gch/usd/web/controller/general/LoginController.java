package am.gch.usd.web.controller.general;

import am.gch.usd.common.data.model.User;
import am.gch.usd.common.data.model.lcp.UserProfile;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage(@RequestParam Optional<String> error) {
        return new ModelAndView("login", "error", error);
    }

    // @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @RequestMapping("/home")
    public String home(@AuthenticationPrincipal User user) {
        if (user.getProfile() == UserProfile.ADMIN) {
            return "redirect:admin/home";
        }
        return "redirect:user/home";
    }
}
