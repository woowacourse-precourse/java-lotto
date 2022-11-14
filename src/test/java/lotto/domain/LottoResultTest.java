package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    private static LottoResult lottoResult;

    @BeforeAll
    static void setUp() {
        lottoResult = new LottoResult();
        lottoResult.add(Ranking.of(0, false)); // MISS
        lottoResult.add(Ranking.of(1, false)); // MISS
        lottoResult.add(Ranking.of(2, false)); // MISS
        lottoResult.add(Ranking.of(3, false)); // FIFTH
        lottoResult.add(Ranking.of(3, false)); // FIFTH
    }

    @DisplayName("당첨금 계산 기능 테스트")
    @Test
    void calculateProfitsTest() {
        long profit = (long) Ranking.FIFTH.getPrize() * 2;
        assertThat(lottoResult.calculateProfits()).isEqualTo(profit);
    }

    @DisplayName("등수별 몇개의 로또가 있는지 확인하는 기능 테스트")
    @Test
    void checkHowManyLottoPerRank() {
        assertThat(lottoResult.get(Ranking.MISS.name())).isEqualTo(3);
        assertThat(lottoResult.get(Ranking.FIFTH.name())).isEqualTo(2);
    }
}
