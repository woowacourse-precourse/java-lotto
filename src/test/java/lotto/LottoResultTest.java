package lotto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoResultTest {
    void resultByNeverAdded() {
        LottoResult results = new LottoResult();

        assertThatThrownBy(() -> results.getYield())
                .isInstanceOf(IllegalArgumentException.class);
    }

    void resultByOneRankAdded() {
        LottoResult results = new LottoResult();
        results.add(LottoRank.SECOND);

        assertThat(results.getYield()).isEqualTo(3000000);
    }

    void resultByTwoRankAdded() {
        LottoResult results = new LottoResult();
        results.add(LottoRank.FOURTH);
        results.add(LottoRank.LOSE);

        assertThat(results.getYield()).isEqualTo(2500);
    }

    void resultByManyRankAdded() {
        LottoResult results = new LottoResult();
        List<LottoRank> ranks = List.of(LottoRank.LOSE, LottoRank.LOSE, LottoRank.LOSE,
                LottoRank.THIRD, LottoRank.LOSE);
        for (LottoRank rank : ranks) {
            results.add(rank);
        }

        assertThat(results.getYield()).isEqualTo(30000);
    }

    void resultByOnlyLose() {
        LottoResult results = new LottoResult();
        List<LottoRank> ranks = List.of(LottoRank.LOSE, LottoRank.LOSE, LottoRank.LOSE, LottoRank.LOSE);
        for (LottoRank rank : ranks) {
            results.add(rank);
        }

        assertThat(results.getYield()).isEqualTo(0);
    }
}