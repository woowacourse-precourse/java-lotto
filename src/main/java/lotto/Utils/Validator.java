package lotto.Utils;

public class Validator {

    public static final int DIVISOR = 1000;
    public static final int ZERO = 0;

    public static final String ERROR = "[ERROR] ";
    public static final String NOT_INTEGER_STATE = "정수만 입력해야 합니다.";
    public static final String NOT_1000UNIT_STATE = "1000원 단위로 입력해야 합니다.";

    protected final String moneyString;
    public Validator(String moneyString){
        this.moneyString = moneyString;
        isInteger();
        is1000Unit();
    };

    private void isInteger(){
        try {
            Util.getInt(moneyString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR + NOT_INTEGER_STATE);
        }
    }

    private void is1000Unit(){
        if ((Util.getInt(moneyString) % DIVISOR) != ZERO){
            throw new IllegalArgumentException(ERROR + NOT_1000UNIT_STATE);
        }
    }

}
