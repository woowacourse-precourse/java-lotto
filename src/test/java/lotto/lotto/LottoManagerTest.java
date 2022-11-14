package lotto.lotto;

import lotto.lotto.Lotto;
import lotto.lotto.LottoManager;
import lotto.lotto.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoManagerTest {

    private static LottoManager lottoManager;

    @BeforeEach
    void init(){
        lottoManager = new LottoManager(1000, new TestNumberGenerator());
    }

    @DisplayName("전부 일치하면 Rank 가 WIN_SIX 이어야 한다.")
    @Test
    void calculateLottoRanksBySIX() {
        List<Lotto> lottos = lottoManager.getLottos();
        Lotto lotto = lottos.get(0);
        lottoManager.calculateTotalRanks(lotto,1);

        assertThat(lottoManager.getRanks().get(Rank.WIN_SIX)).isEqualTo(1);
    }

    @DisplayName("하나만 다르고 bonus 번호가 불일치하면, Rank 가 WIN_FIVE 이어야 한다.")
    @Test
    void calculateEarningRateBySIX() {
        List<Lotto> lottos = lottoManager.getLottos();
        Lotto lotto = lottos.get(0);
        lottoManager.calculateTotalRanks(lotto,0);
        float earningRate = lottoManager.calculateEarningRate();

        assertThat(earningRate).isEqualTo(200000000F);
    }

}