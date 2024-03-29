package boot.controller;

import boot.model.User;
import boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String getUsers(ModelMap model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "list";
    }

    @GetMapping("/add")
    public String newUser(@ModelAttribute("user") User user) {
        return "add";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute("user") User user) {
        if (user.getName().isEmpty() || user.getSurname().isEmpty() || user.getAge() == 0) {
            return "redirect:/users/add";
        }

        userService.save(user);
        return "redirect:/users/list";
    }

    @GetMapping("/edit")
    public String editUser(@RequestParam("id") long id, ModelMap model) {
        model.addAttribute("user", userService.findUserById(id));
        return "edit";
    }

    @PatchMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users/list";
    }
    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") long id) {
        userService.deleteUserById(id);
        return "redirect:/users/list";
    }
}