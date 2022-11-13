package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import user.PurchaseAmount;

import java.util.Arrays;
import java.util.EnumMap;

import static org.assertj.core.api.Assertions.assertThat;

class WinningStatisticTest {

    @DisplayName("구매금액이 주어지면 수익률을 계산한다.")
    @Test
    void 구매금액에_따른_수익률을_계산하는데_성공한다() {
        // given
        EnumMap<Wins, Integer> winningResult = new EnumMap<>(Wins.class);
        PurchaseAmount purchaseAmount = new PurchaseAmount("14000");
        Arrays.stream(Wins.values())
                        .forEach(win -> winningResult.put(win, 0));
        winningResult.computeIfPresent(Wins.THREE_MATCHED, (key, value) -> value + 1);

        WinningStatistic winningStatistic = new WinningStatistic(winningResult);

        // when
        double profitRate = winningStatistic.calculateProfitRate(purchaseAmount);

        // then
        assertThat(profitRate).isEqualTo((double) 5_000 / 14_000 * 100);
    }
}