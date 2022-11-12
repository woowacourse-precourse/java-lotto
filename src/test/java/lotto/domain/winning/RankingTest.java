package lotto.domain.winning;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankingTest {

    public static final String BONUS_FORMAT = "보너스 볼 일치";

    @DisplayName("matchBonusNumber가 true인 LottoRanking은 stringFormat에 '보너스 볼 일치'가 포함된다.")
    @Test
    void trueMatchBonusNumber() {
        Ranking second = Ranking.SECOND;
        assertThat(second.toString()).contains(BONUS_FORMAT);
    }

    @DisplayName("matchBonusNumber가 false인 LottoRanking은 toString에 '보너스 볼 일치'가 포함된다.")
    @Test
    void falseMatchBonusNumber() {
        Ranking second = Ranking.FIRST;
        assertThat(second.toString()).doesNotContain(BONUS_FORMAT);
    }

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