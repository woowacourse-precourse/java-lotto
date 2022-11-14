package Info;

import java.math.BigInteger;

public class PrintGameInfo {
    public static final String ERROR = "[ERROR] ";
    public static final String IS_NOT_DIGIT_STRING = "숫자 이외의 값이 존재합니다.";
    public static final String IS_EMPTY_STRING = "아무 값도 입력하지 않았습니다.";
    public static final String PURCHASE_COUNT = "개를 구매했습니다.";

    public static void purchaseAmountInfo() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void purchaseCount(BigInteger count) {
        System.out.println(count+PURCHASE_COUNT);
    }

    public static String getIsNotDigitString() {
        return ERROR + IS_NOT_DIGIT_STRING;
    }
    public static String getIsEmptyString() {
        return ERROR + IS_EMPTY_STRING;
    }

}
