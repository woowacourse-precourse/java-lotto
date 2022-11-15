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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ProfitTest {

    private NumberGenerator fixedNumberGenerator;

    @BeforeEach
    void setUp() {
        fixedNumberGenerator = new FixedNumberGenerator();
    }

    @ParameterizedTest
    @CsvSource({
            "'8000', '1,2,3,5,10,12', '8', 400_000",
            "'200000', '1,2,3,4,5,6', '8', 400_000_000_000"
    })
    public void calculateProfit(String purchaseCost, String winningNumbers, String bonus, long expected) {
        Cost cost = new Cost(purchaseCost);
        WinningLotto winningLotto = new WinningLotto(winningNumbers);
        BonusNumber bonusNumber = new BonusNumber(bonus, winningLotto);
        LottoGroup lottoGroup = new LottoGroup(cost.getPurchaseCount(), fixedNumberGenerator);
        HitResult result = new HitResult(lottoGroup, winningLotto, bonusNumber);

        Profit profit = new Profit(cost.getCost(), result);

        assertThat(profit.calculateProfit(result))
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("수익률을 계산합니다")
    void calculateEarningsRate() {
        Cost cost = new Cost("8000");
        WinningLotto winningLotto = new WinningLotto("1,2,3,5,10,12");
        BonusNumber bonusNumber = new BonusNumber("8", winningLotto);
        LottoGroup lottoGroup = new LottoGroup(cost.getPurchaseCount(), fixedNumberGenerator);
        HitResult result = new HitResult(lottoGroup, winningLotto, bonusNumber);

        Profit profit = new Profit(cost.getCost(), result);

        assertThat(profit.calculateEarningsRate(cost.getCost()))
                .isEqualTo(5_000);
    }
}