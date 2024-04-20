package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {
    private final UserService us;

    @Autowired
    public UserController(UserService us) {
        this.us = us;
    }
   @GetMapping("/user")
    public String listUsers( ModelMap model) {
        model.addAttribute("users", us.listUsers());
        return "user";
    }
    @GetMapping("/add")
    public String createUserForm(@ModelAttribute("user") User user) {
        return "add";
    }

    @PostMapping("/add")
    public String createUser(@ModelAttribute("user")User user) {
        us.saveUser(user);
        return "redirect:/user";
    }
    @GetMapping("/edit/{id}")
    public String editUserForm(Model model, @PathVariable("id") int id) {
        User user = us.getUserById(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String editUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        user.setId(id);
        us.updateUser(user);
        return "redirect:/user";
    }
    @GetMapping("/delete/{id}")
    public String deleteUserForm(Model model, @PathVariable("id") int id) {
        User user = us.getUserById(id);
        model.addAttribute("allowDelete", true);
        model.addAttribute("user", user);
        return "delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        us.removeById(id);
        return "redirect:/user";
    }
}
