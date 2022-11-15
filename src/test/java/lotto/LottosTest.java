package lotto;
import java.util.List;
import java.util.Map;

import lotto.domain.Lottos;
import lotto.domain.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class LottosTest {
    Lottos lottos;

    @BeforeEach
    void init() {
        lottos = new Lottos(List.of(1,2,3,4,5,6));
    }

    @Test
    void 모든번호_일치시_Rank에_1등저장(){
        lottos.checkRankStatistic(List.of(1,2,3,4,5,6),7);
        Map<Rank, Integer> rankStatistic = lottos.getRankStatistic();
        Assertions.assertThat(rankStatistic.get(Rank.FIRST)).isEqualTo(1);
    }

    @Test
    void 번호5개_보너스1개_일치시_Rank에_2등저장(){
        lottos.checkRankStatistic(List.of(2,3,4,5,6,7),1);
        Map<Rank, Integer> rankStatistic = lottos.getRankStatistic();
        Assertions.assertThat(rankStatistic.get(Rank.SECOND)).isEqualTo(1);
    }
}
