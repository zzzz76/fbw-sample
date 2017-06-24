package io.terminus.fbw.impl;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static io.terminus.fbw.impl.Words.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by IntelliJ IDEA.
 * User: AnsonChan
 * Date: 24/06/2017
 */
public class TalkerTest {
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

    @Test
    public void test1_10() throws Exception {
        Talker talker = new Talker(ImmutableList.of(3, 5, 7));

        List<String> result = IntStream.range(1, 11).mapToObj(talker::talk).collect(Collectors.toList());
        assertThat(result).containsExactly("1", "2", FIZZ, "4", BUZZ, FIZZ, WHIZZ, "8", FIZZ, BUZZ);
    }

    @Test
    public void test51_60() throws Exception {
        Talker talker = new Talker(ImmutableList.of(3, 5, 7));

        List<String> result = IntStream.range(51, 61).mapToObj(talker::talk).collect(Collectors.toList());
        assertThat(result).containsExactly(FIZZ, "52", FIZZ, FIZZ, BUZZ, WHIZZ, FIZZ, "58", "59", FIZZ + BUZZ);
    }

    @Test
    public void test91_100() throws Exception {
        Talker talker = new Talker(ImmutableList.of(3, 5, 7));

        List<String> result = IntStream.range(91, 101).mapToObj(talker::talk).collect(Collectors.toList());
        assertThat(result).containsExactly(WHIZZ, "92", FIZZ, "94", BUZZ, FIZZ, "97", WHIZZ, FIZZ, BUZZ);
    }
}
