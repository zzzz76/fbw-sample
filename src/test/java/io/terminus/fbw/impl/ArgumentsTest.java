package io.terminus.fbw.impl;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created by IntelliJ IDEA.
 * User: AnsonChan
 * Date: 24/06/2017
 */
public class ArgumentsTest {
    @Rule
    public final TextFromStandardInputStream systemInMock = TextFromStandardInputStream.emptyStandardInputStream();

    @Test
    public void testOneArgProvided() throws Exception {
        // 标准输入
        List<Integer> result = Arguments.parse("1,2,3");
        assertThat(result).containsExactly(1, 2, 3);

        // 带空格
        result = Arguments.parse("1, 2, 3");
        assertThat(result).containsExactly(1, 2, 3);

        // 数字带 0
        assertThatThrownBy(() -> Arguments.parse("0,1,2"))
                .isInstanceOf(IllegalArgumentException.class);

        // 不是个位数
        assertThatThrownBy(() -> Arguments.parse("1,2,12"))
                .isInstanceOf(IllegalArgumentException.class);

        // 数字重复
        assertThatThrownBy(() -> Arguments.parse("1,2,2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testThreeArgsProvided() throws Exception {
        // 标准输入
        List<Integer> result = Arguments.parse("1", "2", "3");
        assertThat(result).containsExactly(1, 2, 3);

        // 数字带 0
        assertThatThrownBy(() -> Arguments.parse("0", "1", "2"))
                .isInstanceOf(IllegalArgumentException.class);

        // 不是个位数
        assertThatThrownBy(() -> Arguments.parse("1", "2", "12"))
                .isInstanceOf(IllegalArgumentException.class);

        // 数字重复
        assertThatThrownBy(() -> Arguments.parse("1", "2", "2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testInputFromSystemIn() throws Exception {
        // 标准输入
        systemInMock.provideLines("1,2,3");
        List<Integer> result = Arguments.parse();
        assertThat(result).containsExactly(1, 2, 3);
    }
}
