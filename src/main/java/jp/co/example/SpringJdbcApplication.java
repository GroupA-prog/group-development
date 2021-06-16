package jp.co.example;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import jp.co.example.entity.User;
import jp.co.example.service.UserService;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
				SpringApplication.run(SpringJdbcApplication.class, args);

		UserService userService = context.getBean(UserService.class);
		List<User> list = userService.findAll();
		for (User u : list) {
			System.out.println(u.getUserInfo());
		}
	}

}
