package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Convert {
    public static Integer costConvert(String cost){
        InputValidation.numberFormatExceptionValidation(cost);
        return Integer.parseInt(cost);
    }
    public static Lotto winningConvert(String stringNumbers){
        InputValidation.winningNumberValidation(stringNumbers);
        List<Integer> numbers = Arrays.stream(stringNumbers.split(","))
                .map(number->Integer.parseInt(number))
                .collect(Collectors.toList());
        return new Lotto(numbers);
    }
    public static Integer bonusConvert(String bonus,Lotto winningNumber){
        InputValidation.bonusNumberValidation(bonus,winningNumber);
        return Integer.parseInt(bonus);
    }
}
