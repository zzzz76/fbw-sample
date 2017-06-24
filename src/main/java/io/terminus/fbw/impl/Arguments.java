package io.terminus.fbw.impl;

import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: AnsonChan
 * Date: 24/06/2017
 */
public class Arguments {
    private static final Logger logger = LoggerFactory.getLogger(Arguments.class);

    public static List<Integer> parse(String... args) {
        // 没有任何命令行参数则从标准输入读取
        if (args.length == 0) {
            logger.info("No args input, read from stdin");
            String arg = new Scanner(System.in).nextLine();
            args = new String[]{ arg };
        }

        // 只允许输入一个或三个参数
        if (args.length != 1 && args.length != 3) {
            throw new IllegalArgumentException("not enough arguments provided");
        }
        List<Integer> specialNumbers;
        if (args.length == 1) {
            String arg = args[0].trim();
            // 如果输入的是一个参数，判断格式，逗号分隔的单个数字，允许空格
            if (!Pattern.compile("([1-9]\\s*,\\s*){2}[1-9]").matcher(arg).matches()) {
                throw new IllegalArgumentException("argument format error");
            }
            // split 后转 Integer
            specialNumbers = Splitter.on(",").omitEmptyStrings().trimResults()
                    .splitToList(arg).stream().map(Integer::valueOf)
                    .collect(Collectors.toList());
        } else {
            Pattern singleNumberPattern = Pattern.compile("[1-9]");
            if (!Arrays.stream(args).allMatch(arg -> singleNumberPattern.matcher(arg).matches())) {
                throw new IllegalArgumentException("arguments not a single number");
            }
            // 转 Integer
            specialNumbers = Arrays.stream(args).map(Integer::valueOf)
                    .collect(Collectors.toList());
        }
        // 不能有重复数字
        if (ImmutableSet.copyOf(specialNumbers).size() != specialNumbers.size()) {
            throw new IllegalArgumentException("number duplicated");
        }

        return specialNumbers;
    }
}
