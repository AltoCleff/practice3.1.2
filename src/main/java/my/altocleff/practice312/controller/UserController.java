package my.altocleff.practice312.controller;

import my.altocleff.practice312.exeption.UserNotFoundException;
import my.altocleff.practice312.model.User;
import my.altocleff.practice312.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String userInfo (ModelMap model) {
        model.addAttribute("users", userService.getAll());
        model.addAttribute("user", new User());
        return "userinfo";
    }

    @PostMapping
    public String addUser(@ModelAttribute("user") User user) {

        userService.add(user);

        return "redirect:/";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {

        userService.delete(id);

        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, Model model) {

        model.addAttribute("user", userService.get(id));
        return "update";
    }

    @PostMapping ("/updated")
    public String update(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleRuntimeException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }

}
