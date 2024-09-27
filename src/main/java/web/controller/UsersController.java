package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;


@Controller
public class UsersController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/users")
    public String users(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping(value = "users/addUser")
    public String addUser() {
        return "addUser";
    }

    @GetMapping(value = "users/editUser")
    public String editUser(Model model, @RequestParam("id") int id) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping(value = "/users/addUser")
    public String addUser(@RequestParam(name = "username") String username,
                          @RequestParam(name = "password") String password,
                          @RequestParam(name = "email") String email,
                          @RequestParam(name = "phoneNumber") String phoneNumber,
                          @RequestParam(name = "age") int age,
                          @RequestParam(name = "sex") String sex) {
        User user = new User(username, password, email, phoneNumber, age, sex);
        userService.save(user);
        return "redirect:/users";
    }

    @PostMapping(value = "/users/deleteUser")
    public String deleteUser(@RequestParam(name = "id") int id) {
        userService.delete(userService.findById(id));
        return "redirect:/users";
    }

    @PostMapping(value = "/users/editUser")
    public String editUser(@RequestParam(name = "username") String username,
                           @RequestParam(name = "password") String password,
                           @RequestParam(name = "email") String email,
                           @RequestParam(name = "phoneNumber") String phoneNumber,
                           @RequestParam(name = "age") int age,
                           @RequestParam(name = "sex") String sex,
                           @RequestParam(name = "id") int id) {
        User user = userService.findById(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phoneNumber);
        user.setAge(age);
        user.setSex(sex);
        userService.update(user);
        return "redirect:/users";
    }
}
