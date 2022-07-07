package hyber;

import hyber.config.DataBaseConfig;
import hyber.model.User;
import hyber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDataBaseTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DataBaseConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("Sergey", "Popov", "popov@mail.ru");
        User user2 = new User("Rick", "Sanchez", "rick@mail.ru");
        User user3 = new User("Morty", "Smite", "morty@mail.ru");
        User user4 = new User("Gena", "The Crocodile", "gena@mail.ru");

        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);
        userService.addUser(user4);
    }
}
