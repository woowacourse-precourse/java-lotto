package lotto.utils;

public class MoneyFalseException {
    public static final String errorCode = "[ERROR] 잘못된 금액 입력입니다. 1,000원 단위로 입력하세요";

    public static String catchException(){
        return errorCode;
    }

}
