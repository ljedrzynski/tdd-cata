package pl.ljedrzynski.kata.tdd.fizzbuzz;

public class FizzBuzz {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";

    public void fizzBuzz() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(check(i));
        }
    }

    String check(int i) {
        StringBuilder sb = new StringBuilder();
        if (isDivisibleByThree(i)) sb.append(FIZZ);
        if (isDivisibleByFive(i)) sb.append(BUZZ);
        return sb.length() == 0 ? String.valueOf(i) : sb.toString();
    }

    private boolean isDivisibleByThree(int i) {
        return i % 3 == 0;
    }

    private boolean isDivisibleByFive(int i) {
        return i % 5 == 0;
    }

    public static void main(String[] args) {
        new FizzBuzz().fizzBuzz();
    }

}
