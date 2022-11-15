package lotto;

public class ErrorMessage {
    public static final String DUPLICATED_LUCKY_NUMBER = "[ERROR] 당첨번호에 중복된 숫자가 있습니다.";
    public static final String DUPLICATED_BONUS_NUMBER = "[ERROR] 보너스 번호와 당첨 번호가 같습니다.";
    public static final String LOTTO_SIZE_ERROR = "[ERROR] 로또의 갯수가 6개가 아닙니다.";
    public static final String INVALID_INPUT = "[ERROR] 입력값이 숫자가 아닙니다.";
    public static final String TOO_LOW_PRICE = "[ERROR] 구입금액으로 로또를 구매할 수 없습니다.";
    public static final String NOT_PERFECT_PRICE = "[ERROR] 구입금액이 로또금액으로 나누어 떨어지지 않습니다.";
    public static final String LOW_INPUT_ERROR = "[ERROR] 1보다 작은 번호를 입력하였습니다.";
    public static final String HIGH_INPUT_ERROR = "[ERROR] 45보다 큰 번호를 입력하였습니다.";

    public static void makeException() {
        throw new IllegalArgumentException(INVALID_INPUT);
    }
}


