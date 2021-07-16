package io.github.sazid.courseapi.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(name = "hi", method = RequestMethod.POST)
    public String sayHi() {
        return "Hi";
    }
}
