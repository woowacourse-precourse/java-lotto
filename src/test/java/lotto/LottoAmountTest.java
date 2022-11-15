package lotto;

import lotto.model.LottoAmount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoAmountTest {
    @Test
    void 돈이_부족한_경우() {
        int money = 10;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new LottoAmount(money);
        });
    }

    @Test
    void 거스름돈이_남는_경우() {
        int money = 1111;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new LottoAmount(money);
        });
    }
}