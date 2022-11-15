package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @DisplayName("맞춘 숫자가 5개 이면서, 보너스 숫자를 맞췄을 때, SECOND 인지")
    @Test
    void fiveHitLottoRankSecond() {
        LottoRank lottoRank = LottoRank.valueOf(5,true);
        assertThat(lottoRank).isEqualTo(LottoRank.SECOND);
    }

    @DisplayName("맞춘 숫자가 2개 일 때, FAILED 인지")
    @Test
    void twoHitsLottoFailed() {
        LottoRank lottoRank = LottoRank.valueOf(2,false);
        assertThat(lottoRank).isEqualTo(LottoRank.FAILED);
    }

    @DisplayName("맞춘 숫자가 1개 일 때, FAILED 인지")
    @Test
    void oneHitsLottoFailed() {
        LottoRank lottoRank = LottoRank.valueOf(1,false);
        assertThat(lottoRank).isEqualTo(LottoRank.FAILED);
    }

    @DisplayName("맞춘 숫자가 3개 이면서 보너스 숫자를 맞췄을 때, FIFTH 인지")
    @Test
    void threeHitsLottoRankFifth() {
        LottoRank lottoRank = LottoRank.valueOf(3,true);
        assertThat(lottoRank).isEqualTo(LottoRank.FIFTH);
    }
}