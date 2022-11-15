package lotto;

import lotto.caculation.Money;
import lotto.caculation.Purchase;
import lotto.caculation.Yield;
import lotto.utils.MoneyFalseException;
import lotto.utils.WinningType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class PurchaseTest {

    @ParameterizedTest
    @ValueSource(strings = {"1000"})
    void 금액_로또_개수(String number) {
        assertThat(new Purchase(new Money(number)).getLottoCount()).isEqualTo(1);
    }

    @Test
    void 돈_음수_입력() {
        assertThatThrownBy(() -> new Money("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 미당첨_수익률() {
        Map<WinningType, Integer> winningResult = new HashMap<>();
        winningResult.put(WinningType.NOTHING, 4);
        Money money = new Money("4000");
        Yield yield = new Yield(winningResult);
        assertThat(yield.getYieldOfLotto(money)).isEqualTo(0);
    }

    @Test
    void 당첨_수익률() {
        Map<WinningType, Integer> winningResult = new HashMap<>();
        winningResult.put(WinningType.FIVE_PLACE, 1);
        Money money = new Money("5000");
        Yield yield = new Yield(winningResult);
        assertThat(yield.getYieldOfLotto(money)).isEqualTo(1);
    }
}
