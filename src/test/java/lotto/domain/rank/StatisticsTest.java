package lotto.domain.rank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class StatisticsTest {

    private Statistics statistics;

    @BeforeEach
    void init() {
//        statistics = new Statistics();
//        statistics.setLottoWinResultToMap(5, 1);
//        statistics.setLottoWinResultToMap(2, 0);
//        statistics.setLottoWinResultToMap(3, 0);
//        statistics.setLottoWinResultToMap(3, 0);
    }

    @DisplayName("당첨 맵의 크기는 5여야 한다.")
    @Test
    void getLottoWinMapSize() {
        Map<LottoRank, Integer> result = statistics.getWinLottoInfoMap();

        int mapSize = result.size();

        assertThat(mapSize).isEqualTo(5);
    }

    @DisplayName("같은 당첨 등수라면 개수를 1씩 더해나가면저 맵에 저장한다.")
    @Test
    void setLottoWinMap() {
        Map<LottoRank, Integer> result = statistics.getWinLottoInfoMap();

        Integer count = result.get(LottoRank.FIFTH);

        assertThat(count).isEqualTo(2);
    }

    @DisplayName("로또의 총 당첨 금액을 구한다.")
    @Test
    void getTotalWinAmount() {
        int totalWinAmount = statistics.findTotalWinAmount();

        assertThat(totalWinAmount).isEqualTo(30010000);
    }

    @DisplayName("당첨 금액에 대한 총 수익률을 구한다.")
    @Test
    void getLottoYield() {
        int purchaseAmount = 1000;
        int totalWinAmount = statistics.findTotalWinAmount();
        double lottoYield = statistics.findLottoYield(purchaseAmount);

        assertThat(totalWinAmount).isEqualTo(30010000);
        assertThat(lottoYield).isEqualTo(3001000.0);
    }
}
