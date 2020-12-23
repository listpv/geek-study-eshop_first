package ru.geekbrains.controller;

import general_database.data.UserSadminData;
import general_database.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import general_database.services.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/sadmin_registration")
public class SadminRegistrationController {

    private UserService userService;

    public SadminRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String registration(
            Model model
    ){
        model.addAttribute("userSadminData", new UserSadminData());
        return "sadmin_registration";
    }

    @PostMapping
    public String registration(
            @Valid @ModelAttribute UserSadminData userSadminData,
            BindingResult bindingResult
    ){
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        User user = userService.createUser(userSadminData);
        System.out.println(user);
        return "redirect:/";
    }
}
