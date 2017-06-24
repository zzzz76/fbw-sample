package io.terminus.fbw.impl;

import com.google.common.collect.ImmutableList;

import java.util.List;

import static io.terminus.fbw.impl.Words.BUZZ;
import static io.terminus.fbw.impl.Words.FIZZ;
import static io.terminus.fbw.impl.Words.WHIZZ;

/**
 * Created by IntelliJ IDEA.
 * User: AnsonChan
 * Date: 24/06/2017
 */
public class Talker {
    private static final List<String> WORDS = ImmutableList.of(FIZZ, BUZZ, WHIZZ);
    private final List<Integer> numbers;

    public Talker(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public String talk(Integer index) {
        if (isFirstNumberContains(index)) {
            return WORDS.get(0);
        }
        return multipleTalk(index);
    }

    private boolean isFirstNumberContains(Integer index) {
        return index.toString().contains(numbers.get(0).toString());
    }

    private String multipleTalk(Integer index) {
        boolean isAliquot = false;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            if (index % numbers.get(i) == 0) {
                isAliquot = true;
                result.append(WORDS.get(i));
            }
        }
        return isAliquot ? result.toString() : index.toString();
    }
}
