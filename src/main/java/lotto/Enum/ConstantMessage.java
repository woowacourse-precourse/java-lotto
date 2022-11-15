package lotto.Enum;

public enum ConstantMessage {
    REGEX_ONLY_NUMBER("[0-9]+"),
    REGEX_WINNING_NUMBER_FORMAT("(\\d+,){5}\\d+"),
    REGEX_BONUS_NUMBER_FORMAT("\\d+"),

    SPACE(" "),
    EMPTY(""),

    PRINT_PURCHASE_AMOUNT("개를 구매했습니다."),
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),

    INPUT_LOTTO_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    ;
    private String value;

    ConstantMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
