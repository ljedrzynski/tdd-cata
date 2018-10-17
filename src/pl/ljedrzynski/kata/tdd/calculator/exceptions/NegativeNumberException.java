package pl.ljedrzynski.kata.tdd.calculator.exceptions;

public class NegativeNumberException extends RuntimeException {

    public NegativeNumberException(String message) {
        super(message);
    }
}
