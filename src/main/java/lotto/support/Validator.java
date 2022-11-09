package lotto.support;

public class Validator {
    private static final int UNIT=1000;
    private static final int REMAINDER=0;
    private static final String ERROR_MESSAGE="[ERROR]";
    private static final String MUST_INTEGER=" 입력값이 숫자여야 합니다.";
    private static final String UNMATCHED_UNIT=" 입력값이 1000원 단위여야 합니다.";
    private static final String BELOW_AMOUNT=" 입력값이 1000원 이상이여야 합니다.";
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
    private Integer stringToInteger(String target){
        return Integer.parseInt(target);
    }
}