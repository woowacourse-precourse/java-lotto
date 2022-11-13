package lotto.domain.winning;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//TODO methodSource
class RankingTest {

    @DisplayName("6, false를 입력하면 FIRST 랭킹이 조회된다.")
    @Test
    void lottoRankingFindByMatchNumberCount1() {
        Ranking ranking = Ranking.ranking(6, false);
        assertThat(ranking).isEqualTo(Ranking.FIRST);
    }

    @DisplayName("5, true를 입력하면 SECOND 랭킹이 조회된다.")
    @Test
    void lottoRankingFindByMatchNumberCount2() {
        Ranking ranking = Ranking.ranking(5, true);
        assertThat(ranking).isEqualTo(Ranking.SECOND);
    }
    @DisplayName("5, false를 입력하면 SECOND 랭킹이 아닌 THIRD 랭킹이 조회된다.")
    @Test
    void lottoRankingFindByMatchNumberCount3() {
        Ranking ranking = Ranking.ranking(5, false);
        assertThat(ranking).isEqualTo(Ranking.THIRD);
    }
}