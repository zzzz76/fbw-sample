package io.terminus.fbw.impl;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by IntelliJ IDEA.
 * User: AnsonChan
 * Date: 23/06/2017
 *
 * 这个类看上去没有任何作用，
 * 但实际上 SpringBootTest 因为找到了这个类而没有进一步去找到 src 中的 Application 。
 * 因此不会导致 CommandLineRunner 那个 bean 被执行。
 */
@SpringBootApplication
public class TestConfiguration {
}
