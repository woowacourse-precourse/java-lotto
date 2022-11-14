package lotto.constants;

public enum Error {
    WRONG_PURCHASE_AMOUNT("구매 금액은 1,000원 단위로 입력되어야 합니다."),
    WRONG_PURCHASE_NUM("구매 금액은 숫자로 입력되어야 합니다."),
    WRONG_LOTTO_LENGTH("당첨 번호는 6개 입력되어야 합니다."),
    WRONG_LOTTO_NUM("당첨 번호는 숫자로 입력되어야 합니다."),
    WRONG_LOTTO_RANGE("당첨 번호는 1~45까지의 숫자로 입력되어야 합니다."),
    DUPLICATE_LOTTO_NUM("당첨 번호에 중복되는 숫자가 있습니다."),
    WRONG_BONUS_NUM("보너스 번호는 숫자로 입력되어야 합니다."),
    WRONG_BONUS_RANGE("당첨 번호는 1~45까지의 숫자로 입력되어야 합니다."),
    DUPLICATE_BONUS_NUM("보너스 번호에 중복되는 숫자가 있습니다.");

    private final String msg;
    private final String startmsg = "[ERROR]";

    private Error(String msg) {
        this.msg = startmsg + msg;
    }

    public String getMsg() {
        return msg;
    }
}