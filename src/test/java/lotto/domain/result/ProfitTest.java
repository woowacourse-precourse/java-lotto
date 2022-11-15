package lotto.domain.result;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Cost;
import lotto.domain.generator.FixedNumberGenerator;
import lotto.domain.generator.NumberGenerator;
import lotto.domain.lottery.BonusNumber;
import lotto.domain.lottery.LottoGroup;
import lotto.domain.lottery.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProfitTest {

    private NumberGenerator fixedNumberGenerator;

    @BeforeEach
    void setUp() {
        fixedNumberGenerator = new FixedNumberGenerator(); // [1, 2, 3, 4, 5, 6]
    }

    @Test
    @DisplayName("총 수익을 계산합니다")
    void calculateProfit() {
        Cost cost = new Cost("8000");
        WinningLotto winningLotto = new WinningLotto("1,2,3,5,10,12");
        BonusNumber bonusNumber = new BonusNumber("8", winningLotto);
        LottoGroup lottoGroup = new LottoGroup(cost.getPurchaseCount(), fixedNumberGenerator);
        HitResult result = new HitResult(lottoGroup, winningLotto, bonusNumber); // [0, 5, 0, 0, 0]

        Profit profit = new Profit(cost.getCost(), result);

        assertThat(profit.calculateProfit(result))
                .isEqualTo(400_000L);
    }

    @Test
    @DisplayName("총 수익을 계산합니다 - 큰 수의 경우")
    void calculateProfit_large() {
        Cost cost = new Cost("200000");
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber("8", winningLotto);
        LottoGroup lottoGroup = new LottoGroup(cost.getPurchaseCount(), fixedNumberGenerator);
        HitResult result = new HitResult(lottoGroup, winningLotto, bonusNumber); // [0, 0, 0, 0, 200]

        Profit profit = new Profit(cost.getCost(), result);

        assertThat(profit.calculateProfit(result))
                .isEqualTo(400_000_000_000L);
    }

    @Test
    @DisplayName("수익률을 계산합니다")
    void calculateEarningsRate() {
        Cost cost = new Cost("8000");
        WinningLotto winningLotto = new WinningLotto("1,2,3,5,10,12");
        BonusNumber bonusNumber = new BonusNumber("8", winningLotto);
        LottoGroup lottoGroup = new LottoGroup(cost.getPurchaseCount(), fixedNumberGenerator);
        HitResult result = new HitResult(lottoGroup, winningLotto, bonusNumber); // [0, 5, 0, 0, 0]

        Profit profit = new Profit(cost.getCost(), result);

        assertThat(profit.calculateEarningsRate(cost.getCost()))
                .isEqualTo(5_000);
    }
}