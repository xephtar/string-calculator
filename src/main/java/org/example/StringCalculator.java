package org.example;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class StringCalculator {
    private static final int MAX_LIMIT = 1000;
    private Boolean isNegative(int number) {
        return number < 0;
    }

    private Boolean isIgnorable(int number){
        return number > MAX_LIMIT;
    }

    private int addAll(String[] strArray) {

        ArrayList<String> negativeNumbers = new ArrayList<>();

        int sum = 0;
        for (String s : strArray) {
            if(s.isEmpty()) continue;

            var parsedInt = Integer.parseInt(s);
            if (isNegative(parsedInt)){
                negativeNumbers.add(s);
            }
            if(!isIgnorable(parsedInt)){
                sum += parsedInt;
            }
        }

        if(negativeNumbers.size() > 0){
            throw new InvalidParameterException("error: negatives not allowed: " + String.join(" ", negativeNumbers));
        }

        return sum;
    }

    public Integer Add(String numbers) {
        if(numbers.isEmpty()) return 0;

        numbers = numbers.replaceAll("[^\\d-]",",");

        return addAll(numbers.split(",+"));
    }
}
