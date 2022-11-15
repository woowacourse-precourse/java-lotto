package lotto;

public final class ErrorMessages {
    public static final String NOT_DIGIT = "[ERROR] 숫자를 입력해주세요.";
    public static final String NOT_THOUSAND_UNIT = "[ERROR] 구입 금액은 1,000원 단위로 입력해주세요.";
    public static final String NOT_SIX_DIGIT_NUMBER = "[ERROR] 로또 번호는 6자리 숫자여야 합니다.";
    public static final String DUPLICATE_NUMBER = "[ERROR] 로또 번호는 중복된 숫자가 올 수 없습니다.";
    public static final String NOT_BETWEEN_ONE_AND_FORTY_FIVE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String OUT_OF_BOUND_AMOUNT = "[ERROR] 구입 금액은 1,000원 이상 100,000원 이하여야 합니다.";


    private ErrorMessages() {
    }
}
