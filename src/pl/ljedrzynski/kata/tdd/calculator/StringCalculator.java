package pl.ljedrzynski.kata.tdd.calculator;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import pl.ljedrzynski.kata.tdd.calculator.exceptions.NegativeNumberException;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringCalculator {

    int add(String input) {
        if (StringUtils.isEmpty(input)) {
            return 0;
        }

        char delimiter = getDelimiter(input);

        Supplier<IntStream> supplier = () -> splitInput(input, String.format("[%s,\n]", delimiter))
                .stream()
                .mapToInt(Integer::valueOf);

        assertPositiveNumbers(supplier);

        return supplier.get().sum();
    }

    private void assertPositiveNumbers(Supplier<IntStream> supplier) {
        List<Integer> negatives = supplier.get().filter(value -> value < 0).boxed().collect(Collectors.toList());
        if (negatives.size() > 0) {
            throw new NegativeNumberException(String.format("negatives not allowed -> %s", Arrays.toString(negatives.toArray())));
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

    private List<String> splitInput(String input, String regex) {
        return List.of(input.split(regex)).stream()
                .filter(NumberUtils::isNumber)
                .collect(Collectors.toList());
    }
}
