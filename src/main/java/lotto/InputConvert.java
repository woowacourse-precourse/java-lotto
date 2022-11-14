package lotto;

import java.util.ArrayList;
import java.util.List;

public class InputConvert {

    public static List<Integer> lottoNumber(String input) {
        if(input.length() == 0) {
            throw new IllegalArgumentException();
        }
        String onlyNumber = input.replaceAll("[^0-9]", "");
        String[] numbers = input.split(",");
        if(input.length() - onlyNumber.length() + 1 != numbers.length){
            throw new IllegalArgumentException();
        }
        List<Integer> convertedNumbers = new ArrayList<>();
        for(String number : numbers){
            convertedNumbers.add(Integer.parseInt(number));
        }
        return convertedNumbers;
    }
}
