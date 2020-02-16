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

        User user1 = new User("1", "1");
        User user2 = new User("2", "2");
        userService.add(user1);
        userService.add(user2);
        System.out.println(userService.get(1L));
        userService.listUsers().forEach(System.out::println);
    }
}
