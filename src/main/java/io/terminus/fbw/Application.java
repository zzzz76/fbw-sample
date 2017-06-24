package io.terminus.fbw;

import io.terminus.fbw.impl.FizzBuzzWhizzer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * User: AnsonChan
 * Date: 23/06/2017
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).web(false).run(args);
    }

    @Component
    public static class Startup implements CommandLineRunner {
        @Autowired
        private FizzBuzzWhizzer fizzBuzzWhizzer;

        @Override
        public void run(String... args) throws Exception {
            fizzBuzzWhizzer.run(args);
        }
    }
}
