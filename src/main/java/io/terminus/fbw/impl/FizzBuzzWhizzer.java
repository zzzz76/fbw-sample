package io.terminus.fbw.impl;

import com.google.common.base.Joiner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: AnsonChan
 * Date: 23/06/2017
 */
@Component
public class FizzBuzzWhizzer {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Runner runner;
    @Autowired
    private Arguments arguments;

    public void run(String... args) {
        logger.debug("Get args input: {}", Joiner.on(" - ").join(args));

        List<Integer> specialNumbers = arguments.parse(args);

        logger.info("Get special numbers success: {}", specialNumbers);

        runner.run(specialNumbers);
    }
}
