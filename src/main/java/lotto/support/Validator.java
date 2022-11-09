package lotto.support;

public class Validator {
    private static final String ERROR_MESSAGE="[ERROR]";
    private static final String MUST_INTEGER="입력값이 숫자여야 합니다.";
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
}