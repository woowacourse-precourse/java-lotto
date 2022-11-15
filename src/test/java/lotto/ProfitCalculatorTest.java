package lotto;

import java.util.List;
import java.util.Map;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Prize;
import lotto.domain.ProfitCalculator;
import lotto.strategy.FixedLottoGenerateStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProfitCalculatorTest {

    @DisplayName("1000 지불 후 수익 5천 달성 시 수익률 500")
    @Test
    void profitrate_500_when_pay_1000() {
        Lotto winningNum = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        Lottos lottos = new Lottos(1, new FixedLottoGenerateStrategy());
        Map<Prize, Integer> prizeBoard = LottoMachine.checkPrizes(winningNum, lottos,
            new Bonus(7, winningNum));
        float profitRate = ProfitCalculator.calculateProfitRate(prizeBoard, new Money(1000));
        Assertions.assertThat(profitRate).isEqualTo(500f);
    }


}
