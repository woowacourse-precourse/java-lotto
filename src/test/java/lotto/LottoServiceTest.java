package lotto;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LottoServiceTest {

    @Test
    void makeRandomLottosTest() {
        LottoService lottoService = new LottoService();
        lottoService.makeRandomLottos(5);
        Assertions.assertThat(lottoService.getLottos().size()).isEqualTo(5);
    }

    @Test
    void calculateEarningRateTest() {
        LottoService lottoService = new LottoService();
        List<Integer> allRankings = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5));
        float expected = MoneyConstant.FIRST_PRIZE.getValue() + 2 * MoneyConstant.SECOND_PRIZE.getValue()
                + 3 * MoneyConstant.THIRD_PRIZE.getValue() + 4 * MoneyConstant.FOURTH_PRIZE.getValue()
                +5 * MoneyConstant.FIFTH_PRIZE.getValue();
        expected = (expected/(MoneyConstant.LOTTO_PRICE.getValue()*20))*100;
        Assertions.assertThat(lottoService.calculateEarningRate(allRankings, 20))
                .isCloseTo(expected, Percentage.withPercentage(0.1));
    }
}