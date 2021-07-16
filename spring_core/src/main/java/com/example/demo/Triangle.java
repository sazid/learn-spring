package com.example.demo;

import lombok.Data;

@Data
public class Triangle implements Shape {

    private Point pointA;
    private Point pointB;
    private Point pointC;

    public void draw() {
        System.out.println("Drawing point with points(" + pointA + ", " + pointB + ", " + pointC + ")");
    }

    public void onInit() {
        System.out.println("We're being called after the properties are set. New property values: " + pointA + ", " + pointB + ", " + pointC);
    }

    public void onDestroy() {
        System.out.println("Disposing bean: " + pointA + ", " + pointB + ", " + pointC);
    }
}
