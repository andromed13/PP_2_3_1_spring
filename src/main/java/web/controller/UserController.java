package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceImpl;

import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String users(Model model) {
        List<User> users = userService.listUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute ("user") User user) {
        return "new";
    }

    @PostMapping
    public String addOrUpdate(@ModelAttribute ("user") User user) {
        if (user.getId() != null) {
            userService.update(user);
        } else {
            userService.add(user);
        }
        return "redirect:/users";
    }

    @GetMapping("/update")
    public String update(Model model, @RequestParam("id") Long id) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "new";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}

