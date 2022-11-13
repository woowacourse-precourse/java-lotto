package lotto.constant;

public class Message {

    private static final String INPUT_USER_MONEY_MESSAGE = "구입금액을 입력해 주세요.";

    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String INPUT_ERROR_USER_MONEY_MESSAGE = ERROR_MESSAGE + "%d단위로만 입력 가능합니다. 게임을 종료합니다.%n";

    public static void printInputUserMoney(){
        System.out.println(INPUT_USER_MONEY_MESSAGE);
    }

    public static void printInputErrorUserMoney(){
        System.out.printf(INPUT_ERROR_USER_MONEY_MESSAGE, 1000);
    }
}
