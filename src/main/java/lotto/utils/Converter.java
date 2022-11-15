package lotto.utils;

import java.util.ArrayList;
import java.util.List;

import static lotto.utils.Constants.DELIMITER;

public class Converter {

    public List<Integer> convertToLuckyNumber(String input) {
        List<Integer> luckyNumber = new ArrayList<>();

        addNumber(luckyNumber, getNumbers(input));
        return luckyNumber;
    }

    private String[] getNumbers(String input) {
        return input.split(DELIMITER);
    }

    private void addNumber(List<Integer> luckyNumber, String[] numbers) {
        for (int index = 0; index < numbers.length; index++) {
            luckyNumber.add(Integer.parseInt(numbers[index]));
        }
    }
}
