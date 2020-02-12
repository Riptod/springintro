package mate.academy.spring;

import mate.academy.spring.config.AppConfig;
import mate.academy.spring.model.User;
import mate.academy.spring.service.UserService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        User user1 = new User();
        user1.setEmail("1");
        user1.setPassword("1");
        User user2 = new User();
        user2.setEmail("2");
        user2.setPassword("2");
        userService.add(user1);
        userService.add(user2);
        userService.listUsers().forEach(System.out::println);
    }
}
