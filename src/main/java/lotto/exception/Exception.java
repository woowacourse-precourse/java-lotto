package lotto.exception;

import lotto.option.Option;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.exception.ExceptionMessage.*;

public class Exception{

    private static void throwException(Boolean bool,String error){
        if(bool) throw new IllegalArgumentException(error);
    }

    public static void catchInputException(String input){
            throwException((Integer.parseInt(input)%1000 !=0 ),INPUT_ERROR.error);
    }
    public static void catchOutOfRangeException(Integer input){
            throwException((input<Option.MIN.option|Option.MAX.option<input),OUT_OF_RANGE_ERROR.error);
    }
    public static void catchDuplicatedException(List<Integer> input){
        Set<Integer> inputSet = new HashSet<>(input);
        throwException((inputSet.size()!=input.size()),DUPLICATED_ERROR.error);
    }
    public static void catchWrongCountNumberException(List<Integer> input){
        throwException(input.size()!=Option.COUNT.option,WRONG_COUNT_ERROR.error);
    }
    public static void catchNotNumericalInputException(String input){
        throwException((!input.matches("[0-9,',']+")),NOT_NUMBER_ERROR.error);
    }
}
