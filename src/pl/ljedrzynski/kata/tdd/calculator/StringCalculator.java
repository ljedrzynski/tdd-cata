package pl.ljedrzynski.kata.tdd.calculator;


import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class StringCalculator {

    int add(String input) {
        if (StringUtils.isEmpty(input)) {
            return 0;
        }

        return splitInput(input, "[,\n]").stream()
                .mapToInt(Integer::valueOf)
                .sum();
    }

    private List<String> splitInput(String input, String regex) {
        return List.of(input.split(regex));
    }
}
