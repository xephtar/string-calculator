package org.example;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class StringCalculator {
    private static final int MAX_LIMIT = 1000;
    private Boolean isNegative(int number) {
        return number < 0;
    }

    private String getDelimiter(String numbers){
        var template = "//";
        if(numbers.startsWith(template)){
            var newLineIndex = numbers.lastIndexOf("\n");
            var delimiterString = numbers.substring(2, newLineIndex);

            if(delimiterString.length() == 1){
                return  delimiterString;
            }

            return delimiterString.replaceAll("\\[|\\]", "");
        }
        return ",|\n";
    }

    private String cleanNumbers(String numbers, String delimiter){
        if(delimiter.equals(",|\n")){
                return numbers;
        }
        return numbers.replaceAll("//.+\n", "");
    }

    private Boolean isIgnorable(int number){
        return number > MAX_LIMIT;
    }

    private int addAll(String[] strArray) {

        ArrayList<String> negativeNumbers = new ArrayList<>();

        int sum = 0;
        for (String s : strArray) {
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

        var delimiter = getDelimiter(numbers);
        numbers = cleanNumbers(numbers, delimiter);
        numbers = numbers.replaceAll("[^\\d-]",",");

        return addAll(numbers.split(",+"));
    }
}
