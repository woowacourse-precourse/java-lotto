package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {
    @Test
    @DisplayName("1등인지 확인")
    void firstRank() {
        assertAll(
                () -> assertThat(LottoRank.parseRank(6, false)).isEqualTo(LottoRank.FIRST),
                () -> assertThat(LottoRank.parseRank(6, true)).isEqualTo(LottoRank.FIRST)
        );
    }
    
    @Test
    @DisplayName("2등인지 확인")
    void secondRank() {
        assertThat(LottoRank.parseRank(5, true)).isEqualTo(LottoRank.SECOND);
    }
    
    @Test
    @DisplayName("3등인지 확인")
    void thirdRank() {
        assertThat(LottoRank.parseRank(5, false)).isEqualTo(LottoRank.THIRD);
    }
}