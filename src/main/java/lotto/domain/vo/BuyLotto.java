package lotto.domain.vo;

public class BuyLotto {
    private static final String OUTPUT_ERROR = "[ERROR] ";
    private static final String OUTPUT_ERROR_NOT_UNIT = "1000원 단위로 입력해주세요.";
    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO = 0;
    private final int money;

    public BuyLotto(int money) {
        moneyValidate(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    private void moneyValidate(int money) {
        if (money % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException(OUTPUT_ERROR + OUTPUT_ERROR_NOT_UNIT);
        }
    }

    public int lottoTicketsCount() {
        return money / LOTTO_PRICE;
    }
}
