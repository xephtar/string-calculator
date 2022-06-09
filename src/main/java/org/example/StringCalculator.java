package org.example;

public class StringCalculator {
    public Integer Add(String numbers) {
        var template = "//";
        var delimiter = ",|\n";
        if(numbers.startsWith(template)){
            delimiter = numbers.substring(2,3);
            numbers = numbers.substring(4);
        }

        if(numbers.equals("")) return 0;

        String[] strArray = numbers.split(delimiter);

        int sum = 0;
        for (String s : strArray) {
            sum += Integer.parseInt(s);
        }

        return sum;
    }
}
