package com.pradipta.reportsuspect.auth;
import com.pradipta.reportsuspect.auth.models.user.User;
import com.pradipta.reportsuspect.auth.models.user.UserService;
import com.pradipta.reportsuspect.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ModelAndView login() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return new ModelAndView("forward:/home");
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView register() {
        User user = new User();
        UserDto userDto = new UserDto();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userDto", userDto);
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView registerUser(@Valid UserDto userDto, BindingResult result, ModelMap modelMap) {
        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
            modelAndView.addObject("successMessage", "Please correct the errors");
            modelMap.addAttribute("bindingResult", result);
        } else if (userService.userExistsByDTO(userDto)) {
            System.out.println("User exists");
            modelAndView.addObject("successMessage", "User with email exists");
            modelMap.addAttribute("bindingResult", result);
        }
        else {
            System.out.println(userDto.getEmail());
            userService.saveUserByDTO(userDto);
        }
        modelAndView.addObject("userDto", new UserDto());
        modelAndView.setViewName("register");
        return modelAndView;
    }
}
