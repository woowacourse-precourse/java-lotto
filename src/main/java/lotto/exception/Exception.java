package lotto.exception;

import org.junit.jupiter.params.shadow.com.univocity.parsers.common.input.InputAnalysisProcess;

public class Exception {
    private static final String INPUT_ERROR = "입력금액은 1000원단위여야 합니다.";
    private static void throwException(String error){
        throw new IllegalArgumentException(error);
    }

    public static void catchInputException(String input){
        if(Integer.parseInt(input)%1000 !=0 ){
            throwException(INPUT_ERROR);
        }
    }
}
