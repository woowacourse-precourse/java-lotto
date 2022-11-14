package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class LottoCalculatorTest {

    private LottoCalculator calculator;

    @BeforeEach
    public void before() {
        calculator = new LottoCalculator();
    }

    @DisplayName("내 로또 번호와 당첨 내역을 비교해서 당첨 횟수를 계산해야한다.")
    @Test
    void calculateMyWinningPrize() {
        List<Lotto> lottoPacks = List.of(new Lotto(List.of(1,2,3,4,5,6)), new Lotto(List.of(1,2,3,4,5,7)));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;

        Map<LottoMatch, Integer> matchedLottoCount = calculator.calWinningPrize(lottoPacks, winningNumbers, bonusNumber);
        Assertions.assertThat(matchedLottoCount.getOrDefault(LottoMatch.SIX, 0)).isEqualTo(1);
        Assertions.assertThat(matchedLottoCount.getOrDefault(LottoMatch.BONUS, 0)).isEqualTo(1);
        Assertions.assertThat(matchedLottoCount.getOrDefault(LottoMatch.FIVE, 0)).isEqualTo(0);
        Assertions.assertThat(matchedLottoCount.getOrDefault(LottoMatch.FOUR, 0)).isEqualTo(0);
        Assertions.assertThat(matchedLottoCount.getOrDefault(LottoMatch.THREE, 0)).isEqualTo(0);
    }

    @DisplayName("투자 금액과 당첨 내역을 바탕으로 수익률을 계산해야한다.")
    @Test
    void calculateMyPriceRate() {
        List<Lotto> lottoPacks = List.of(new Lotto(List.of(1,2,3,4,5,13)), new Lotto(List.of(9,36,12,29,30,42)));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;

        Map<LottoMatch, Integer> matchedLottoCount = calculator.calWinningPrize(lottoPacks, winningNumbers, bonusNumber);
        Double rate = calculator.calEarningRate(2000, matchedLottoCount);
        Assertions.assertThat(rate).isEqualTo(75000);
    }
}