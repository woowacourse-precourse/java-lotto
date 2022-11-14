package lotto;

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
        return List.of(1,2,3,4,5,6);
    }
}
