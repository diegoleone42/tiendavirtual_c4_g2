package co.edu.unbosque.tiendavirtual1_front;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class Tiendavirtual1FrontApplication {

	public static void main(String[] args) {
		SpringApplication.run(Tiendavirtual1FrontApplication.class, args);
	}
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}

}
