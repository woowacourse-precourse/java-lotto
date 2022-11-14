package lotto.domain.result;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.generator.FixedNumberGenerator;
import lotto.domain.generator.NumberGenerator;
import lotto.domain.lottery.BonusNumber;
import lotto.domain.lottery.LottoGroup;
import lotto.domain.lottery.WinningLotto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProfitTest {

    private static Result result;

    @BeforeAll
    static void initialize() {
        NumberGenerator fixedNumberGenerator = new FixedNumberGenerator();
        LottoGroup lottoGroup = new LottoGroup(5, fixedNumberGenerator);
        WinningLotto winningLotto = new WinningLotto("1,2,3,5,10,12");
        BonusNumber bonusNumber = new BonusNumber("8", winningLotto);
        result = new Result(lottoGroup, winningLotto, bonusNumber); // 0, 5, 0, 0, 0
    }

    @Test
    @DisplayName("총 수익을 계산합니다")
    void calculateProfit() {
        int purchaseCost = 8000;
        Profit profit = new Profit(purchaseCost, result);

        assertThat(profit.calculateProfit(result))
                .isEqualTo(250_000);
    }

    @Test
    @DisplayName("수익률을 계산합니다")
    void calculateEarningsRate() {
        int purchaseCost = 8000;
        Profit profit = new Profit(purchaseCost, result);

        assertThat(profit.calculateEarningsRate(purchaseCost))
                .isEqualTo(3_125);
    }
}