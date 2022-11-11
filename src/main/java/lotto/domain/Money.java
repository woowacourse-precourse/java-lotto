package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Money {
    private final Integer myMoney;
    private final Integer lottoCount;

    public Money(Integer money) {
        validate(money);
        this.myMoney = money;
        this.lottoCount = money / 1000;
    }

    public Integer getLottoCount() {
        return lottoCount;
    }

    private void validate(Integer money) {
        if ((money % 1000) != 0) {
            throw new IllegalArgumentException();
        }
    }
}
