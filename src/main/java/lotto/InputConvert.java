package lotto;

import java.util.ArrayList;
import java.util.List;

public class InputConvert {

    public static List<Integer> lottoNumber(String input) {
        lottoValidate(input);
        return lottoConvert(input);
    }
    private static void lottoValidate(String input) {
        if(isInputLengthZero(input)){
            throw new IllegalArgumentException();
        }
        if(isAllCharacterNumberAndComma(input)){
            throw new IllegalArgumentException();
        }
    }
    private static boolean isInputLengthZero(String input) {
        return input.length() == 0;
    }
    private static boolean isAllCharacterNumberAndComma(String input) {
        String onlyNumber = input.replaceAll("[^0-9]", "");
        String[] numbers = input.split(",");
        return input.length() - onlyNumber.length() + 1 != numbers.length;
    }
    private static List<Integer> lottoConvert(String input) {
        String[] numbers = input.split(",");
        List<Integer> convertedNumbers = new ArrayList<>();
        for (String number : numbers) {
            convertedNumbers.add(Integer.parseInt(number));
        }
        return convertedNumbers;
    }
}
