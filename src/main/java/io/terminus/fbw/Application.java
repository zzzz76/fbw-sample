package io.terminus.fbw;

import io.terminus.fbw.impl.Game;
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
        @Override
        public void run(String... args) throws Exception {
            Game game = new Game(100);
            game.play(args);
        }
    }
}
