package com.example.springboot.counter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "counter not found");
        }
    }
}
