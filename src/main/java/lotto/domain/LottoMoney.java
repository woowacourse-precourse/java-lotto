package lotto.domain;

import static lotto.domain.LottoTicketSeller.LOTTO_PRICE;

import lotto.view.Output;

public class LottoMoney {

    private static final String UNIT_OF_MONEY_ERROR = "구매 금액은 1000원 단위로 입력 가능합니다.";
    private static final String MONEY_ONLY_NUMBER_MESSAGE = "구입 금액은 숫자만 입력 가능합니다.";
    private long money;

    public LottoMoney(String money) {
        this.money = validate(parseLong(money));
    }

    private long validate(long money) {
        if (money % LOTTO_PRICE == 0 && money > 0) {
            return money;
        }
        Output.printExceptionMessage(UNIT_OF_MONEY_ERROR);
        throw new IllegalArgumentException();
    }

    private long parseLong(String money) {
        try {
            return Long.parseLong(money);
        } catch (IllegalArgumentException e) {
            Output.printExceptionMessage(MONEY_ONLY_NUMBER_MESSAGE);
            throw e;
        }
    }


    public long getQuantityByUnit(int unit) {
        return money / unit;
    }

    public double getMoney() {
        return this.money;
    }
}