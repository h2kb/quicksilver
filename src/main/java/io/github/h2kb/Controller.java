package io.github.h2kb;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping(path = "/quicksilver")
public class Controller {

    AtomicInteger count = new AtomicInteger();
    Task task1 = new Task(count.incrementAndGet(), "Bilbo Baggins");
    Task task2 = new Task(count.incrementAndGet(), "Ivan Petro");
    Task task3 = new Task(count.incrementAndGet(), "Harry Potter");
    Task task4 = new Task(count.incrementAndGet(), "Mark Cyrk");
    Task task5 = new Task(count.incrementAndGet(), "John Baptist");

    ArrayList<Task> tasks = new ArrayList<Task>();

    @GetMapping("/operator")
    public ResponseEntity<ArrayList<Task>> task() {
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);
        tasks.add(task5);

        return new ResponseEntity<ArrayList<Task>>(tasks, HttpStatus.OK);
    }
}

