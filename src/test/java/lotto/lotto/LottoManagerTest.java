package lotto.lotto;

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
    void calculateLottoRanksByAllMatch() {
        lottoManager.calculateTotalRanks(new Lotto(List.of(1,2,3,4,5,6)),7);
        assertThat(lottoManager.getRanks().get(Rank.WIN_SIX)).isEqualTo(1);
    }

    @DisplayName("하나만 사고 6개 다 맞췄을 때의 수익률은 200000000%이다.")
    @Test
    void calculateEarningRateByAllMatch() {
        lottoManager.calculateTotalRanks(new Lotto(List.of(1,2,3,4,5,6)),7);
        float earningRate = lottoManager.calculateEarningRate();

        assertThat(earningRate).isEqualTo(200000000F);
    }

    @DisplayName("5개 일치하고, 보너스 번호가 일치하면 Rank 가 WIN_FIVE_WITH_BONUS 이어야 한다.")
    @Test
    void calculateLottoRanksByFIVE_WITH_BONUS() {
        lottoManager.calculateTotalRanks(new Lotto(List.of(1,2,3,4,5,7)),6);
        assertThat(lottoManager.getRanks().get(Rank.WIN_FIVE_WITH_BONUS5)).isEqualTo(1);
    }

    @DisplayName("5개 일치하고, 보너스 번호가 일치하지 않으면 Rank 가 WIN_FIVE 이어야 한다.")
    @Test
    void calculateLottoRanksByWIN_FIVE() {
        lottoManager.calculateTotalRanks(new Lotto(List.of(1,2,3,4,5,7)),8);
        assertThat(lottoManager.getRanks().get(Rank.WIN_FIVE)).isEqualTo(1);
    }

    @DisplayName("4개 일치하면 Rank 가 WIN_FOUR 이어야 한다.")
    @Test
    void calculateLottoRanksByWIN_FOUR() {
        lottoManager.calculateTotalRanks(new Lotto(List.of(1,2,3,4,8,7)),6);
        assertThat(lottoManager.getRanks().get(Rank.WIN_FOUR)).isEqualTo(1);
    }

    @DisplayName("3개 일치하면 Rank 가 WIN_THREE 이어야 한다.")
    @Test
    void calculateLottoRanksByWIN_THREE() {
        lottoManager.calculateTotalRanks(new Lotto(List.of(1,2,3,9,8,7)),6);
        assertThat(lottoManager.getRanks().get(Rank.WIN_THREE)).isEqualTo(1);
    }

    @DisplayName("3개 아래면 Rank 가 MISS 이어야 한다.")
    @Test
    void calculateLottoRanksByMISS() {
        lottoManager.calculateTotalRanks(new Lotto(List.of(1,2,10,9,8,7)),6);
        assertThat(lottoManager.getRanks().get(Rank.MISS)).isEqualTo(1);
    }

}