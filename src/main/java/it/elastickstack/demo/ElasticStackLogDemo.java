package it.elastickstack.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@SpringBootApplication
@Slf4j
@RestController
public class ElasticStackLogDemo {

    public static void main(String[] args) {
        SpringApplication.run(ElasticStackLogDemo.class, args);
    }

    @GetMapping("/time")
    public String test() {
        var res = Instant.now().toString();
        log.info("Current time {}", res);
        return res;
    }

    @GetMapping("/error")
    public void err() {
        var err = "Error level log";
        log.error("{} -> {}", err, Instant.now().toString());
        throw new RuntimeException(err);
    }

    @GetMapping("/logs")
    public String log() {
        var time = Instant.now().toString();
        log.error("error  in {}", time);
        log.info("info  in {}", time);
        log.warn("warn  in {}", time);
        log.debug("debug  in {}", time);
        return time;
    }

}
