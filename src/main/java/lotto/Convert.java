package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Convert {
    public static Integer costConvert(String cost){
        InputValidation.numberFormatExceptionValidation(cost);
        return Integer.parseInt(cost);
    }
    public static Lotto winningConvert(String numbers){
        InputValidation.winningNumberValidation(numbers);
        return new Lotto(
                Arrays.stream(numbers.split(","))
                        .map(number->Integer.parseInt(number))
                        .collect(Collectors.toList()));
    }
}
