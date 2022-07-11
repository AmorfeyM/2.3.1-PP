package web.controller;

import hyber.model.User;
import hyber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
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
    @PatchMapping("/updateUser")
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/deleteUser/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.removeUser(id);
        return "redirect:/";
    }
}
