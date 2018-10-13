package pl.ljedrzynski.kata.tdd.calculator;

public class StringCalculator {


    int add(String numbers) {
        if (numbers.equals("")) {
            return 0;
        }
        int sum = 0;

        String[] nums = numbers.split("[,\n]");
        for (String num : nums) {
            sum += Integer.valueOf(num);
        }

        return sum;
    }
}
