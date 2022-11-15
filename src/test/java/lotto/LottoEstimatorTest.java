package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoEstimator;
import lotto.domain.LottoStatics;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoEstimatorTest {
    private LottoStatics lottoStatics;
    @BeforeEach
    void setUp(){
        final byte[] buf = String.join("\n", "1,2,3,4,5,6","7").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        List<Lotto> purchasedLotteries = new ArrayList<>(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(1, 2, 3, 4, 5, 7))));
        lottoStatics = new LottoEstimator(WinningLotto.create()).estimate(purchasedLotteries);

    }

    @Test
    void 로또_등수_매기기() {
        HashMap<LottoRank, Integer> expected = new HashMap<>();
        for (LottoRank lottoRank : LottoRank.values()) {
            expected.put(lottoRank, 0);
        }
        expected.put(LottoRank.FIRST_PLACE, 1);
        expected.put(LottoRank.SECOND_PLACE, 1);

        HashMap<LottoRank, Integer> result = lottoStatics.rankStatics();

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 수익률_구하기() {
        float result = lottoStatics.profitRate();

        assertThat(result).isEqualTo(1.015E8f);
    }
}
