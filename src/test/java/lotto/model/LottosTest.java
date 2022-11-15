package lotto.model;

import java.util.List;
import java.util.Map;
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

    @DisplayName("번호가 모두 일치하면 랭크통계 맵에는 1등이 저장되야한다.")
    @Test
    void checkRankWhenFirst(){
        lottos.checkRankStatistic(List.of(1,2,3,4,5,6),7);
        Map<Rank, Integer> rankStatistic = lottos.getRankStatistic();
        Assertions.assertThat(rankStatistic.get(Rank.FIRST)).isEqualTo(1);
    }

    @DisplayName("번호5개와 보너스번호가 일치하면 랭크통계 맵에는 2등이 저장되야한다.")
    @Test
    void checkRankWhenSecond(){
        lottos.checkRankStatistic(List.of(2,3,4,5,6,7),1);
        Map<Rank, Integer> rankStatistic = lottos.getRankStatistic();
        Assertions.assertThat(rankStatistic.get(Rank.SECOND)).isEqualTo(1);
    }
}
