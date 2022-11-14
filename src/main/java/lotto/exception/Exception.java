package lotto.exception;

import org.junit.jupiter.params.shadow.com.univocity.parsers.common.input.InputAnalysisProcess;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public enum Exception {
    INPUT_ERROR("[ERROR] 입력금액은 1000원단위여야 합니다."),
    OUT_OF_RANGE_ERROR("[ERROR] 1~45사이의 숫자여야합니다."),
    DUPLICATED_ERROR("[ERROR] 서로 다른 숫자를 입력해야합니다."),
    NOT_NUMBER_ERROR("[ERROR] 공백 없이 ,와 숫자를 입력해야합니다."),
    WRONG_COUNT_ERROR("[ERROR] 6개의 숫자를 입력해야합니다.");
    private String error;

    Exception(String error){
        this.error = error;
    }
    private static void throwException(Boolean bool,String error){
        if(bool) throw new IllegalArgumentException(error);
    }

    public static void catchInputException(String input){
            throwException((Integer.parseInt(input)%1000 !=0 ),INPUT_ERROR.error);
    }
    public static void catchOutOfRangeException(Integer input){
            throwException((input<1|45<input),OUT_OF_RANGE_ERROR.error);
    }
    public static void catchDuplicatedException(List<Integer> input){
        Set<Integer> inputSet = new HashSet<>(input);
        throwException((inputSet.size()!=input.size()),DUPLICATED_ERROR.error);
    }
    public static void catchWrongCountNumberException(List<Integer> input){
        throwException(input.size()!=6,WRONG_COUNT_ERROR.error);
    }
    public static void catchNotNumericalInputException(String input){
        throwException((!input.matches("[0-9,',']+")),NOT_NUMBER_ERROR.error);
    }
}
