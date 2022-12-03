package lotto.domain;

public enum ErrorMessage {
    LOTTO_SIZE("[ERROR] 로또 번호는 6개의 숫자로 구성되어야 합니다."),
    LOTTO_RANGE("[ERROR] 로또 번호는 1~45 사이의 숫자로 구성되어야 합니다."),
    LOTTO_DUPLICATE("[ERROR] 로또 번호에 중복된 숫자가 있습니다."),

    PURCHASE_PRICE_TYPE("[ERROR] 구입 금액은 숫자로 구성되어야 합니다."),
    PURCHASE_PRICE_UNIT("[ERROR] 구입 금액은 1,000 단위의 수로 입력해야 합니다.."),
    PURCHASE_PRICE_RANGE("[ERROR] 구입 금액은 1,000 이상의 수로 입력해야 합니다."),

    WIN_NUMBER_TYPE("[ERROR] 당첨 번호는 숫자, 쉼표로 구성되어야 합니다."),
    BONUS_NUMBER_TYPE("[ERROR] 보너스 번호는 숫자로만 구성되어야 합니다."),
    BONUS_NUMBER_SAME("[ERROR] 보너스 번호는 당첨 번호와 중복되면 안 됩니다."),
    BONUS_NUMBER_RANGE("[ERROR] 보너스 번호는 1~45 사이 숫자이어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
