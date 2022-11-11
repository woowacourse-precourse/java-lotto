package lotto.enums;

public enum ErrorMessage {
    INVALID_AMOUNT_INPUT("[ERROR] " + ConstVariable.STANDARD + "원 단위로 입력해야 합니다."),
    INVALID_WIN_NUMBERS_INPUT("[ERROR] 당첨 로또 번호는" + ConstVariable.MIN_NUMBER + "부터 " + ConstVariable.MAX_NUMBER + " 사이의 숫자이면서, 쉼표로 구분되어야 합니다."),
    INVALID_NUMBER("[ERROR] 로또 번호는 " + ConstVariable.MIN_NUMBER + "부터 " + ConstVariable.MAX_NUMBER + " 사이의 숫자여야 합니다."),
    INVALID_COUNT("[ERROR] 로또 번호는 총 " + ConstVariable.LOTTO_COUNT + "개의 숫자여야 합니다."),
    HAVE_DUPLICATED_NUMBER("[ERROR] 모든 번호는 중복되지 않아야 합니다."),
    INVALID_BONUS_NUMBER("[ERROR] 보너스 번호는 기존의 번호와 중복되지 않아야 합니다.");

    private final String value;

    ErrorMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
