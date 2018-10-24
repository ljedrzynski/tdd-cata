package pl.ljedrzynski.kata.tdd.calculator;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import pl.ljedrzynski.kata.tdd.calculator.exceptions.NegativeNumberException;

import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringCalculator {

    int add(String input) {
        if (StringUtils.isEmpty(input)) {
            return 0;
        }

        Supplier<IntStream> sup = () -> stringToIntStream(input, getDelimiter(input))
                .filter(value -> value <= 1000);

        assertPositiveNumbers(sup);

        return sup.get().sum();
    }

    private IntStream stringToIntStream(String input, char delimiter) {
        return List.of(input.split(String.format("[%s,\n]", delimiter))).stream()
                .filter(NumberUtils::isNumber)
                .mapToInt(Integer::valueOf);
    }

    private void assertPositiveNumbers(Supplier<IntStream> sup) {
        List<Integer> negatives = sup.get()
                .filter(integer -> integer < 0)
                .boxed()
                .collect(Collectors.toList());
        if (negatives.size() > 0) {
            throw new NegativeNumberException(String.format("negatives not allowed - %s", negatives.toArray()));
        }
    }

    private char getDelimiter(String input) {
        char delimiter;
        if (input.contains("//")) {
            delimiter = input.charAt(2);
        } else {
            delimiter = ',';
        }
        return delimiter;
    }
}
