package lotto.enums;

public enum ErrorMessage {
    INVALID_AMOUNT_INPUT(ConstVariable.STANDARD.getValue() + "원 단위로 입력해야 합니다."),
    INVALID_WIN_NUMBERS_INPUT("당첨 로또 번호는" + ConstVariable.MIN_NUMBER.getValue() + "부터 " + ConstVariable.MAX_NUMBER.getValue() + " 사이의 숫자이면서, 쉼표로 구분되어야 합니다."),
    INVALID_NUMBER("로또 번호는 " + ConstVariable.MIN_NUMBER.getValue() + "부터 " + ConstVariable.MAX_NUMBER.getValue() + " 사이의 숫자여야 합니다."),
    INVALID_COUNT("로또 번호는 총 " + ConstVariable.LOTTO_COUNT.getValue() + "개의 숫자여야 합니다."),
    HAVE_DUPLICATED_NUMBER("모든 번호는 중복되지 않아야 합니다."),
    INVALID_BONUS_NUMBER("보너스 번호는 기존의 번호와 중복되지 않아야 합니다.");

    private final String value;
    private static final String ERROR_MESSAGE = "[ERROR] ";

    ErrorMessage(String value) {
        this.value = ERROR_MESSAGE + value;
    }

    public String getValue() {
        return value;
    }
}
