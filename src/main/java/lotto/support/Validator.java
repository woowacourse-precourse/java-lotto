package lotto.support;

import java.util.List;

public class Validator {
    private static final int UNIT=1000;
    private static final int REMAINDER=0;
    private static final int START_RANGE=1;
    private static final int END_RANGE=45;
    private static final String ERROR_MESSAGE="[ERROR] ";
    private static final String MUST_INTEGER="입력값이 숫자여야 합니다.";
    private static final String UNMATCHED_UNIT="입력값이 1000원 단위여야 합니다.";
    private static final String BELOW_AMOUNT="입력값이 1000원 이상이여야 합니다.";
    private static final String NUMERIC_RANGE="1~45 사이의 숫자여야 합니다.";
    private static final String NUMBER_OF_DIGIT="자리 숫자여야 합니다.";
    private static final String REGEX = "[0-9]+";
    private static final Validator instance=new Validator();
    private Validator(){}

    public static Validator getInstance(){
        return instance;
    }
    public void checkInteger(String target){
        if(!target.matches(REGEX)){
            System.out.println(ERROR_MESSAGE+MUST_INTEGER);
            throw new IllegalArgumentException();
        }
    }
    public void checkUnit(String target){
        if((stringToInteger(target)%UNIT)!=REMAINDER){
            System.out.println(ERROR_MESSAGE+UNMATCHED_UNIT);
            throw new IllegalArgumentException();
        }
    }
    public void checkBelow(String target){
        if(stringToInteger(target)<UNIT){
            System.out.println(ERROR_MESSAGE+BELOW_AMOUNT);
            throw new IllegalArgumentException();
        }
    }
    public void checkNumericalRange(List<Integer> target){
        for(Integer num:target){
            if(num<START_RANGE||num>END_RANGE){
                System.out.println(ERROR_MESSAGE+NUMERIC_RANGE);
                throw new IllegalArgumentException();
            }
        }
    }
    public void checkNumberOfDigit(Integer digit,List<Integer> target){
        if(target.size()!=digit){
            System.out.println(ERROR_MESSAGE+digit+NUMBER_OF_DIGIT);
            throw new IllegalArgumentException();
        }
    }
    private Integer stringToInteger(String target){
        return Integer.parseInt(target);
    }
}