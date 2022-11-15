package lotto.util;

public enum ErrorMessage {
    NULL("[ERROR] null 입력입니다."),
    EMPTY("[ERROR] 빈 문자열 입력입니다."),
    NOT_INTEGER_TYPE("[ERROR] 정수형 입력이 아닙니다."),
    LOTTO_SIZE_EXCEEDED("[ERROR] 로또 번호의 개수는 6입니다."),
    LOTTO_NUMBERS_REPEATED("[ERROR] 로또 번호는 중복될 수 없습니다."),
    LOTTO_NUMBERS_NOT_IN_RANGE("[ERROR] 로또 번호는 1이상 45이하 정수입니다."),
    INVALID_PURCHASE_UNIT("[ERROR] 구입 금액은 1,000원 단위입니다."),
    BONUS_NUMBER_REPEATED("[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다.");
    
    private final String text;

    ErrorMessage(String text) {
        this.text = text;
    }

    public String text() {
        return text;
    }
}