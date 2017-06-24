package io.terminus.fbw.impl;

import com.google.common.base.Joiner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: AnsonChan
 * Date: 23/06/2017
 */
public class Game {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final Integer endAt;

    public Game(Integer endAt) {
        this.endAt = endAt;
    }

    public void play(String... args) {
        logger.debug("Get args input: {}", Joiner.on(" - ").join(args));

        List<Integer> specialNumbers = Arguments.parse(args);

        logger.info("Get special numbers success: {}", specialNumbers);

        Talker talker = new Talker(specialNumbers);
        for (int i = 1; i <= endAt; i++) {
            System.out.println(talker.talk(i));
        }
    }
}
