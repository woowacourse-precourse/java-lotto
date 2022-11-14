package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class InputValidation {
    public static final String NUMBER_FORMAT_MESSAGE = "[ERROR] 숫자만 입력해주세요.";
    private static boolean numberFormatExceptionValidation(String stringNumber){
        try{
            Integer.parseInt(stringNumber);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(NUMBER_FORMAT_MESSAGE);
        }
        return true;
    }
}
