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
}