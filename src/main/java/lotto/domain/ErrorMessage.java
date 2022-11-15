package lotto.domain;

public enum ErrorMessage {
    PURCHASE_AMOUNT_ONLY_NUMBER("[ERROR] 숫자만 입력해야 합니다."),
    PURCHASE_AMOUNT_RIGHT_RANGE("[ERROR] 1000원 이상 구매해야 합니다."),
    PURCHASE_AMOUNT_RIGHT_UNIT("[ERROR] 1000원 단위로 구매해야 합니다."),

    LOTTO_NUMBER_SIZE("[ERROR] 로또 번호는 숫자 6개로 구성해야 한다."),
    LOTTO_NUMBER_RANGE("[ERROR] 로또 번호는 1~45 의 숫자로 구성해야 한다."),
    LOTTO_NUMBER_UNDUPLICATE("[ERROR] 로또 번호에 중복된 숫자가 있으면 안된다."),

    WINNIG_NUMBER_ONLY_NUMBER_AND_COMMA("[ERROR] 로또 당첨 번호는 숫자와 쉼표만으로 구성해야 한다."),

    BONUS_NUMBER_ONLY_NUMBER("[ERROR] 로또 보너스 번호는 숫자로 구성해야 한다."),
    BONUS_NUMBER_NOT_DUPLICATE_WINNING_NUMBER("[ERROR] 로또 보너스 번호는 로또 당첨 번호와 중복되면 안된다."),
    BONUS_NUMBER_RANGE("[ERROR] 로또 보너스 번호는 1~45 의 숫자로 구성해야 한다."),;

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
