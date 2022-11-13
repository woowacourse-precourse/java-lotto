package lotto.exception;

import org.junit.jupiter.params.shadow.com.univocity.parsers.common.input.InputAnalysisProcess;

public enum Exception {
    INPUT_ERROR("입력금액은 1000원단위여야 합니다."),
    OUT_OF_RANGE_ERROR("서로 다른 숫자를 입력해야합니다.");
    private String error;

    Exception(String error){
        this.error = error;
    }
    private static void throwException(String error){
        throw new IllegalArgumentException(error);
    }

    public static void catchInputException(String input){
        if(Integer.parseInt(input)%1000 !=0 ){
            throwException(INPUT_ERROR.error);
        }
    }
    public static void catchOutOfRangeException(Integer input){
        if(input<1|45<input){
            throwException(OUT_OF_RANGE_ERROR.error);
        }
    }
}
