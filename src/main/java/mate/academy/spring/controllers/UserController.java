package mate.academy.spring.controllers;

import java.util.ArrayList;
import java.util.List;

import mate.academy.spring.dto.UserResponseDto;
import mate.academy.spring.model.User;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{userId}")
    public UserResponseDto get(@PathVariable Long userId) {
        User user = userService.get(userId);
        return new UserResponseDto(user.getEmail(), user.getPassword());
    }

    @GetMapping(value = "/getAll")
    public List<UserResponseDto> getAll() {
        List<UserResponseDto> usersDto = new ArrayList<>();
        for (User user : userService.listUsers()) {
            UserResponseDto userDto = new UserResponseDto(user.getEmail(), user.getPassword());;
            usersDto.add(userDto);
        }
        return usersDto;
    }

    @GetMapping(value = "/inject")
    public void inject() {
        userService.add(new User("1", "1"));
        userService.add(new User("2", "2"));
        userService.add(new User("3", "3"));
        userService.add(new User("4", "4"));
    }
}
