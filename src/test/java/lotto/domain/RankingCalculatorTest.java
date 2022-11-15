package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RankingCalculatorTest {

    @Test
    void getLottoRanking() {
        int amount = 3;
        LottoGenerator lottoGenerator = new LottoGenerator(amount);

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        LottoResult lottoResult = new LottoResult(winningNumbers, bonusNumber);

        List<Ranking> actual = RankingCalculator.getLottoRanking(lottoGenerator, lottoResult);
        Assertions.assertThat(actual.size()).isEqualTo(amount);
    }
}