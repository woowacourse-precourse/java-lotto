package lotto.domain;

public class Exception {

    public static final int DIVISOR = 1000;
    public static final int ZERO = 0;

    public static final String ERROR = "[ERROR] ";

    public static final String NOT_INTEGER_STATE = "정수만 입력해야 합니다.";
    public static final String NOT_1000UNIT_STATE = "1000원 단위로 입력해야 합니다.";


    public Exception(){

    };

    public static int isValidAmount(String s){
        int num ;

        try {
            num = is1000Unit(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR + NOT_INTEGER_STATE);
        }

        return num;
    }

    public static int is1000Unit(String s){
        int num = Integer.parseInt(s);

        if ((num % DIVISOR) != ZERO){
            throw new IllegalArgumentException(ERROR + NOT_1000UNIT_STATE);
        }

        return num;
    }

}
