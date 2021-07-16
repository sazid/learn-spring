package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
//@AllArgsConstructor
public class Point {
    private int x;
    private int y;
}
