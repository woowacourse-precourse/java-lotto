package lotto;

import java.util.ArrayList;
import java.util.List;

public class InputConvert {

    public static List<Integer> lottoNumber(String input) {
        lottoValidate(input);
        return lottoConvert(input);
    }
    private static void lottoValidate(String input) {
        CheckInputLength(input);
        CheckCharacterState(input);
    }
    private static void CheckInputLength(String input) {
        if (input.length() == 0) {
            throw new IllegalArgumentException();
        }
    }
    private static void CheckCharacterState(String input) {
        String onlyNumber = input.replaceAll("[^0-9]", "");
        String[] numbers = input.split(",");
        if (input.length() - onlyNumber.length() + 1 != numbers.length) {
            throw new IllegalArgumentException();
        }
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
