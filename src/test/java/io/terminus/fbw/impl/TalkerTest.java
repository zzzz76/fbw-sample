package io.terminus.fbw.impl;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by IntelliJ IDEA.
 * User: AnsonChan
 * Date: 24/06/2017
 */
public class TalkerTest {
    private final String FIZZ = "Fizz";
    private final String BUZZ = "Buzz";
    private final String WHIZZ = "Whizz";

    @Test
    public void test357() throws Exception {
        Talker talker = new Talker(ImmutableList.of(3, 5, 7));

        assertThat(talker.talk(3)).isEqualTo(FIZZ);
        assertThat(talker.talk(5)).isEqualTo(BUZZ);
        assertThat(talker.talk(7)).isEqualTo(WHIZZ);

        assertThat(talker.talk(6)).isEqualTo(FIZZ);
        assertThat(talker.talk(10)).isEqualTo(BUZZ);
        assertThat(talker.talk(14)).isEqualTo(WHIZZ);

        assertThat(talker.talk(15)).isEqualTo(FIZZ + BUZZ);
        assertThat(talker.talk(105)).isEqualTo(FIZZ + BUZZ + WHIZZ);

        assertThat(talker.talk(13)).isEqualTo(FIZZ);
        assertThat(talker.talk(35)).isEqualTo(FIZZ);

        assertThat(talker.talk(1)).isEqualTo("1");
        assertThat(talker.talk(2)).isEqualTo("2");
        assertThat(talker.talk(11)).isEqualTo("11");
    }
}
