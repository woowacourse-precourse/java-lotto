package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoEstimator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoEstimatorTest {
    private LottoEstimator lottoEstimator;

    @BeforeEach
    void setUp(){
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> purchasedLotteries = new ArrayList<>();
        purchasedLotteries.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        purchasedLotteries.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));

        lottoEstimator = new LottoEstimator(purchasedLotteries, winningLotto, 7);
    }

    @Test
    void 로또_등수_매기기() {
        HashMap<LottoRank, Integer> expected = new HashMap<>();
        for (LottoRank lottoRank : LottoRank.values()) {
            expected.put(lottoRank, 0);
        }
        expected.put(LottoRank.FIRST_PLACE, 1);
        expected.put(LottoRank.SECOND_PLACE, 1);

        HashMap<LottoRank, Integer> result = lottoEstimator.estimate();

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 수익률_구하기() {
        lottoEstimator.estimate();
        float result = lottoEstimator.getRateOfProfit();

        assertThat(result).isEqualTo(1.015E8f);
    }
}
