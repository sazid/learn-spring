package com.example.demo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Data
public class Circle implements Shape, ApplicationEventPublisherAware {

    @Autowired
    private Point center;

    private double radius;

    private ApplicationEventPublisher publisher;

    // @Bean(name = "unitCircle")
    @Bean
    public static Circle unitCircle() {
        var c = new Circle();
        c.setRadius(1.0);
        return c;
    }

    @Override
    public void draw() {
        System.out.println("Drawing cricle with center " + center + " and radius " + radius);
        var event = new DrawEvent(this);
        publisher.publishEvent(event);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }
}

class DrawEvent extends ApplicationEvent {
    public DrawEvent(Object source) {
        super(source);
    }

    @Override
    public String toString() {
        return "Draw event occurred";
    }
}
