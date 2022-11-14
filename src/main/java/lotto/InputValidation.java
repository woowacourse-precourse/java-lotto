package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidation {
    public static final String NUMBER_FORMAT_MESSAGE = "[ERROR] 숫자만 입력해주세요.";
    public static boolean numberFormatExceptionValidation(String stringNumber){
        try{
            Integer.parseInt(stringNumber);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(NUMBER_FORMAT_MESSAGE);
        }
        return true;
    }
    public static void winningNumberValidation(String winningNumber){
        Arrays.stream(winningNumber.split(","))
                .filter(element -> numberFormatExceptionValidation(element))
                .map(element -> Integer.parseInt(element));
    }
}

