package io.terminus.fbw.impl;

import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: AnsonChan
 * Date: 24/06/2017
 */
public class GameTest {
    @Test
    public void test10() throws Exception {
        new Game(10).play("3,5,7");
    }
}
