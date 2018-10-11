package pl.ljedrzynski.kata.tdd.roman;


import java.util.HashMap;
import java.util.Map;

public class RomanNumeral {

    private Map<String, Integer> map;

    public RomanNumeral() {
        map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
    }

    public int convert(String roman) {
        int result = 0;

        for (int i = 0; i < roman.length(); i++) {
            int right = getNext(roman, i);

            int current = map.get(String.valueOf(roman.charAt(i)));
            if (right > current) {
                current *= -1;
            }

            result += current;
        }

        return result;
    }

    private int getNext(String roman, int i) {
        int right = 0;

        if (i < roman.length() - 1) {
            String rightRoman = roman.substring(i + 1, i + 2);
            right = map.get(rightRoman);
        }

        return right;
    }
}
