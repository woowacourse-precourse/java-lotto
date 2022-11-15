package lotto.domain.rank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRanksTest {

    private LottoRanks lottoRanks;

    @BeforeEach
    void init() {
        Map<LottoRank, Long> rankMap = new HashMap<>();
        rankMap.put(LottoRank.THIRD, 1L);
        rankMap.put(LottoRank.FOURTH, 2L);
        rankMap.put(LottoRank.FIFTH, 3L);
        lottoRanks = new LottoRanks(rankMap);
    }

    @DisplayName("로또의 총 당첨 금액을 구한다.")
    @Test
    void getTotalWinAmount() {
        int totalWinAmount = lottoRanks.findTotalWinAmount();

        assertThat(totalWinAmount).isEqualTo(1615000);
    }
}
