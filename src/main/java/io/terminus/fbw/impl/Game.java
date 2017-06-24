package io.terminus.fbw.impl;

import com.google.common.base.Joiner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by IntelliJ IDEA.
 * User: AnsonChan
 * Date: 23/06/2017
 */
public class Game {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final Integer startAt;
    private final Integer endAt;

    public Game(Integer startAt, Integer endAt) {
        this.startAt = startAt;
        this.endAt = endAt;
    }

    public void play(String... args) {
        logger.debug("Get args input: {}", Joiner.on(" - ").join(args));
        List<Integer> specialNumbers = Arguments.parse(args);
        logger.info("Get special numbers success: {}", specialNumbers);

        Talker talker = new Talker(specialNumbers);
        logger.info("Start play game from {} to {}", startAt, endAt);
        IntStream.range(startAt, endAt + 1).forEach(i -> System.out.println(talker.talk(i)));
    }
}
