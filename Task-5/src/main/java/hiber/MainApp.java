package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("Ivan", "Smirnov", "ivan@gmail.com");
        User user2 = new User("Anna", "Ivanova", "anna@gmail.com");
        User user3 = new User("Oleg", "Petrov", "oleg@gmail.com");
        User user4 = new User("Julia", " Morozova", "julia@gmail.com");

        Car car1 = new Car("Audi", 6);
        Car car2 = new Car("BMW", 5);
        Car car3 = new Car("Toyota", 3);
        Car car4 = new Car("Mercedes-Benz", 4);

        userService.add(user1.setCar(car1).setUser(user1));
        userService.add(user2.setCar(car2).setUser(user2));
        userService.add(user3.setCar(car3).setUser(user3));
        userService.add(user4.setCar(car4).setUser(user4));

        for (User user : userService.listUsers()) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar().getModel() + " " + user.getCar().getSeries());
            System.out.println();
        }

        User user = userService.getUserByCar("BMW", 5);
        System.out.println(user);


        context.close();
    }
}
