package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoResultTest {

    @DisplayName("로또 당첨 수 더하기 성공")
    @Test
    void testPlusLottoResult() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.plusLottoResult(Match.THREE);

        assertThat(lottoResult.getLottoMatchCountByKey(Match.THREE)).isEqualTo(1);
    }

    @DisplayName("총 당첨금 합산 성공")
    @Test
    void testGetPrizeMoney() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.plusLottoResult(Match.THREE);
        lottoResult.plusLottoResult(Match.THREE);

        double prizeMoney = lottoResult.getPrizeMoney();

        assertThat(prizeMoney).isEqualTo(10000.0);
    }
}
