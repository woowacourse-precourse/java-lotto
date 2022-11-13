package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeCalculatorTest {
    @Test
    void calculateTest() {
        List<LottoRank> lottoRanks = new ArrayList<>(List.of(
                LottoRank.FIRST, LottoRank.SECOND, LottoRank.THIRD,
                LottoRank.FORTH, LottoRank.FIFTH, LottoRank.NOTHING,
                LottoRank.NOTHING, LottoRank.NOTHING));
        PrizeCalculator calculator = new PrizeCalculator();
        int prize = calculator.calculate(lottoRanks);
        assertThat(prize).isEqualTo(2031555000);
    }

    @DisplayName("로또를 구입하지 않은 경우")
    @Test
    void calculateTest2() {
        List<LottoRank> lottoRanks = new ArrayList<>(List.of());
        PrizeCalculator calculator = new PrizeCalculator();
        int prize = calculator.calculate(lottoRanks);
        assertThat(prize).isEqualTo(0);
    }
}