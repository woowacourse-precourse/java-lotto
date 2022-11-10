package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {
    @DisplayName("1등인지 확인")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(booleans = {true, false})
    void firstRank(final boolean existBonusLottoNumber) {
        assertThat(LottoRank.parseRank(6, existBonusLottoNumber)).isEqualTo(LottoRank.FIRST);
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
    
    @DisplayName("4등인지 확인")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(booleans = {true, false})
    void fourthRank(final boolean existBonusLottoNumber) {
        assertThat(LottoRank.parseRank(4, existBonusLottoNumber)).isEqualTo(LottoRank.FOURTH);
    }
}