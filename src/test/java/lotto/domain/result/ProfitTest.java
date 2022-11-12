package lotto.domain.result;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoGroup;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProfitTest {

    private static Result result;

    @BeforeAll
    static void initialize() {
        List<Lotto> lotteries = List.of(
                new Lotto(List.of(4, 6, 8, 14, 26, 37)),
                new Lotto(List.of(4, 6, 10, 14, 25, 36)),
                new Lotto(List.of(1, 2, 13, 20, 21, 22)),
                new Lotto(List.of(1, 2, 13, 20, 21, 22)),
                new Lotto(List.of(1, 2, 13, 20, 21, 22)),
                new Lotto(List.of(1, 2, 13, 20, 21, 22)),
                new Lotto(List.of(1, 2, 13, 20, 21, 22))
        );
        LottoGroup lottoGroup = new LottoGroup(lotteries);
        WinningLotto winningLotto = new WinningLotto("4,6,14,25,36,41");
        BonusNumber bonusNumber = new BonusNumber("8", winningLotto);
        result = new Result(lottoGroup, winningLotto, bonusNumber); // 1, 0, 1, 0, 0
    }

    @Test
    @DisplayName("총 수익을 계산합니다")
    void calculateProfit() {
        int purchaseCost = 8000;
        Profit profit = new Profit(purchaseCost, result);

        assertThat(profit.calculateProfit(result))
                .isEqualTo(1505000);
    }

    @Test
    @DisplayName("수익률을 계산합니다")
    void calculateEarningsRate() {
        int purchaseCost = 8000;
        Profit profit = new Profit(purchaseCost, result);

        assertThat(profit.calculateEarningsRate(purchaseCost))
                .isEqualTo(18812.5);
    }
}