package com.example.springboot.counter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/counter")
public class CounterController {

    @Autowired
    CounterRepository repository;

    @GetMapping("/{id}")
    Counter get(@PathVariable Long id) {
        Optional<Counter> counter = repository.findById(id);
        Counter found = counter.orElseGet(() -> new Counter(id));
        found.increase();
        repository.save(found);
        return found;
    }
}
