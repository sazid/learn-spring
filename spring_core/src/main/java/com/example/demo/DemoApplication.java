package com.example.demo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;

//@SpringBootApplication
@ComponentScan
@Configuration
public class DemoApplication {

    public static void main(String[] args) {
//        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(DemoApplication.class);
		context.registerShutdownHook();

//        Shape triangle = (Shape) context.getBean("triangle");
//        triangle.draw();
//
//        Shape t = (Shape) context.getBean("triangle1");
//        ((Triangle) t).setPointA(new Point(20, 30));
//        t.draw();

        Shape circluarShape = (Shape) context.getBean("circle");
        circluarShape.draw();

        Shape unitCircle = (Shape) context.getBean("unitCircle");
        unitCircle.draw();

        //		SpringApplication.run(DemoApplication.class, args);

//        printUnitCircle();

        System.out.println(context.getBean("myUnitCircleShape"));
    }
}

@Data
@Component
class MyUnitCircleShape {
    @Autowired
    private Circle unitCircle;
}
