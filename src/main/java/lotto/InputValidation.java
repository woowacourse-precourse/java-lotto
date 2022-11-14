package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidation {
    public static final String NUMBER_FORMAT_MESSAGE = "[ERROR] 숫자만 입력해주세요.";
    public static final String COMMA_FORMAT_MESSAGE = "[ERROR] 당첨 번호는 ','로 구분해주세요.";
    public static boolean numberFormatExceptionValidation(String stringNumber){
        try{
            Integer.parseInt(stringNumber);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(NUMBER_FORMAT_MESSAGE);
        }
        return true;
    }
    public static void winningNumberValidation(String winningNumber){
        int numberSize = Arrays.stream(winningNumber.split(","))
                .filter(element -> numberFormatExceptionValidation(element))
                .map(element -> Integer.parseInt(element))
                .collect(Collectors.toList()).size();
        if(numberSize != LottoValidation.LOTTO_COUNT) throw new IllegalArgumentException(NUMBER_FORMAT_MESSAGE);
    }
}

