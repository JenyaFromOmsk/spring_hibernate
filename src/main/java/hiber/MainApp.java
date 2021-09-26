package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
      UserService userService = context.getBean(UserService.class);

      User jack = new User("Jack", "Daniels", "jack@jm.ru");
      jack.setCar(new Car("tesla model x", 123));
      userService.add(jack);

      User evgeniy = new User("Evgeniy", "Rudkovskiy", "evgeniy@jm.ru");
      evgeniy.setCar(new Car("tesla model s", 456));
      userService.add(evgeniy);

      User pepega = new User("Pepega", "Memovna", "pepega@mail.ru");
      pepega.setCar(new Car("tesla model 3", 789));
      userService.add(pepega);

      User oleg = new User("Oleg", "Tinkoff", "oleg@tinkoff.ru");
      oleg.setCar(new Car("tesla cybertruck", 777));
      userService.add(oleg);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getCar());
         System.out.println();
      }

      List <User> user = userService.getUser("tesla cybertruck", 777);
      System.out.println(user);
      context.close();
   }
}
