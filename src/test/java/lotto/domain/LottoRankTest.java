package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
    
    @DisplayName("5등인지 확인")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(booleans = {true, false})
    void fifthRank(final boolean existBonusLottoNumber) {
        assertThat(LottoRank.parseRank(3, existBonusLottoNumber)).isEqualTo(LottoRank.FIFTH);
    }
    
    @DisplayName("꽝인지 확인")
    @ParameterizedTest(name = "{displayName} : 매칭 번호 개수 => {0}, 보너스 번호 매칭 여부 => {1}")
    @CsvSource(value = {"2, true", "2, false", "1, true", "1, false", "0, true", "0, false"})
    void fifthRank(final int countOfSameLottoNumber, final boolean existBonusLottoNumber) {
        assertThat(LottoRank.parseRank(countOfSameLottoNumber, existBonusLottoNumber)).isEqualTo(LottoRank.MISS);
    }
}