package lotto.domain.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoRankTest {

    @DisplayName("매치 카운트 값으로 Enum 값을 찾는다 : matchCount : 6")
    @Test
    void findEnumByMatchCountSix() {
        assertThat(LottoRank.find("6")).isEqualTo(LottoRank.SIX_MATCHES);
    }

    @DisplayName("매치 카운트 값으로 Enum 값을 찾는다 : matchCount : 5")
    @Test
    void findEnumByMatchCountFive() {
        assertThat(LottoRank.find("5")).isEqualTo(LottoRank.FIVE_MATCHES);
    }

    @DisplayName("매치 카운트 값으로 Enum 값을 찾는다 : matchCount : 4")
    @Test
    void findEnumByMatchCountFour() {
        assertThat(LottoRank.find("4")).isEqualTo(LottoRank.FOUR_MATCHES);
    }

    @DisplayName("매치 카운트 값으로 Enum 값을 찾는다 : matchCount : 3")
    @Test
    void findEnumByMatchCountThree() {
        assertThat(LottoRank.find("3")).isEqualTo(LottoRank.THREE_MATCHES);
    }

    @DisplayName("매치 카운트 값으로 Enum 값을 찾는다 : matchCount : 2 이하")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "2"})
    void findEnumByMatchCountThree(String input) {
        assertThat(LottoRank.find(input)).isEqualTo(LottoRank.NO_MATCH);
    }

    @DisplayName("로또 5개 일치, 5개 + 보너스 번호 일치 로직 확인 : 5개 일치")
    @Test
    void checkFiveMatch(){
        assertThat(LottoRank.of(LottoRank.FIVE_MATCHES, false)).isEqualTo(LottoRank.FIVE_MATCHES);
    }

    @DisplayName("로또 5개 일치, 5개 + 보너스 번호 일치 로직 확인 : 5개 + 보너스 일치")
    @Test
    void checkFiveBonusMatch(){
        assertThat(LottoRank.of(LottoRank.FIVE_MATCHES, true)).isEqualTo(LottoRank.FIVE_BONUS_MATCHES);
    }
}