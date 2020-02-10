package io.github.h2kb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping(path = "/quicksilver")
public class Controller {

    @GetMapping("/operator")
    public Task task(@RequestParam String client) {
        return new Task(new AtomicInteger().incrementAndGet(), client);
    }
}

