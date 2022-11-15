package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoEstimator;
import lotto.domain.LottoStatics;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
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
        String result = lottoStatics.getRankStaticsResult();

        assertThat(result).contains("3개 일치 (5,000원) - 0개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                "6개 일치 (2,000,000,000원) - 1개");
    }

    @Test
    void 수익률_구하기() {
        String result = lottoStatics.getProfitRateResult();

        assertThat(result).contains("총 수익률은 101500000.0%입니다.");
    }
}
