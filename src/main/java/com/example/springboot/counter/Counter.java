package com.example.springboot.counter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Counter {
    @Id
    Long id;

    Long count;

    LocalDateTime timestamp;

    public void increase() {
        this.count += 1;
    }

    public Counter(Long id, Long count, LocalDateTime timestamp) {
        this.id = id;
        this.count = count;
        this.timestamp = timestamp;
    }

    public Counter() {
        this(0L);
    }

    public Counter(Long id) {
        this(id, 0L, LocalDateTime.now());
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Counter counter = (Counter) o;

        return Objects.equals(id, counter.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "id=" + id +
                ", count=" + count +
                ", timestamp=" + timestamp +
                '}';
    }
}
