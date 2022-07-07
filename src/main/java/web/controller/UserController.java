package web.controller;

import hyber.config.DataBaseConfig;
import hyber.model.User;
import hyber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller

public class UserController {

    private AnnotationConfigApplicationContext context;

    private UserService userService;

    public UserController() {
        context = new AnnotationConfigApplicationContext(DataBaseConfig.class);
        userService = context.getBean(UserService.class);
    }

    @GetMapping(value = "/")
    public String showAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }
    @GetMapping("/viewUser")
    public String newUser(@ModelAttribute("newUser") User user) {
        return "viewUser";
    }
    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/";
    }
    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable("id") Long id) {
        model.addAttribute("userToUpdate", userService.getOneUser(id));
        return "updateUser";
    }
    @PostMapping("/updateUser")
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @GetMapping("/deleteUser/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.removeUser(id);
        return "redirect:/";
    }
}
