package lotto.constants;

public enum Error {
    WRONG_LOTTOS_LENGTH("[ERROR] 로또 번호는 6개 입력되어야 합니다."),
    WRONG_LOTTOS_RANGE("[ERROR] 로또 번호는 1~45까지의 숫자로 입력되어야 합니다."),
    DUPLICATE_LOTTOS_NUM("[ERROR] 로또 번호에 중복되는 숫자가 있습니다."),
    WRONG_PURCHASE_AMOUNT_UNIT("[ERROR] 구매 금액은 1,000원 단위로 입력되어야 합니다."),
    WRONG_PURCHASE_AMOUNT_NUM("[ERROR] 구매 금액은 숫자로 입력되어야 합니다."),
    LESS_THAN_LOTTO_PRICE("[ERROR] 구매 금액이 1,000원 이하입니다."),
    WRONG_LOTTO_LENGTH("[ERROR] 당첨 번호는 6개 입력되어야 합니다."),
    WRONG_LOTTO_NUM("[ERROR] 당첨 번호는 숫자로 입력되어야 합니다."),
    WRONG_LOTTO_RANGE("[ERROR] 당첨 번호는 1~45까지의 숫자로 입력되어야 합니다."),
    DUPLICATE_LOTTO_NUM("[ERROR] 당첨 번호에 중복되는 숫자가 있습니다."),
    WRONG_BONUS_NUM("[ERROR] 보너스 번호는 숫자로 입력되어야 합니다."),
    WRONG_BONUS_NUM_RANGE("[ERROR] 당첨 번호는 1~45까지의 숫자로 입력되어야 합니다."),
    DUPLICATE_BONUS_NUM("[ERROR] 보너스 번호에 중복되는 숫자가 있습니다.");

    private final String msg;

    Error(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}