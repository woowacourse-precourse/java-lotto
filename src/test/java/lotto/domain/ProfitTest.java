package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ProfitTest {
    @Test
    @DisplayName("수익률 검증")
    void 수익률_검증(){
        // given
        Map<RankingType, Integer> countByRankingType = Map.of(
                RankingType.FIFTH, 1,
                RankingType.DROP_OUT, 4
        );
        int investment = 5000;
        // when
        Profit profit = new Profit(countByRankingType, investment);
        // then
        Assertions.assertThat(profit.getProfitRate()).isEqualTo(100);
    }
}