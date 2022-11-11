package lotto.domain.winning;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankingTest {

    public static final String BONUS_FORMAT = "보너스 볼 일치";

    @DisplayName("matchBonusNumber가 true인 LottoRanking은 stringFormat에 '보너스 볼 일치'가 포함된다.")
    @Test
    void trueMatchBonusNumber() {
        LottoRanking second = LottoRanking.SECOND;
        assertThat(second.stringFormat()).contains(BONUS_FORMAT);
    }

    @DisplayName("matchBonusNumber가 false인 LottoRanking은 stringFormat에 '보너스 볼 일치'가 포함된다.")
    @Test
    void falseMatchBonusNumber() {
        LottoRanking second = LottoRanking.FIRST;
        assertThat(second.stringFormat()).doesNotContain(BONUS_FORMAT);
    }

    @DisplayName("bonus number와 관련 없는 랭킹 정보를 matchNumberCount로 찾을 수 있다.")
    @Test
    void lottoRankingFindByMatchNumberCount1() {
        LottoRanking lottoRanking = LottoRanking.lottoRanking(6);
        assertThat(lottoRanking).isEqualTo(LottoRanking.FIRST);
    }

    @DisplayName("5를 입력 받으면 SECOND 랭킹이 아닌 THIRD 랭킹이 조회된다.")
    @Test
    void lottoRankingFindByMatchNumberCount2() {
        LottoRanking lottoRanking = LottoRanking.lottoRanking(5);
        assertThat(lottoRanking).isEqualTo(LottoRanking.THIRD);
    }
}