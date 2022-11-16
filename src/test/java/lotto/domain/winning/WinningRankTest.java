package lotto.domain.winning;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningRankTest {

    @DisplayName("보너스볼 적중 여부와 관계없이 로또 결과가 1등인지 테스트한다.")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void checkFirstPlace(boolean isBonus) {
        assertThat(WinningRank.of(6, isBonus)).isEqualTo(WinningRank.FIRST);
    }

    @DisplayName("로또 결과가 2등인지 테스트한다.")
    @Test
    void checkSecondPlace() {
        assertThat(WinningRank.of(5, true)).isEqualTo(WinningRank.SECOND);
    }

    @DisplayName("로또 결과가 3등인지 테스트한다.")
    @Test
    void checkThirdPlace() {
        assertThat(WinningRank.of(5, false)).isEqualTo(WinningRank.THIRD);
    }

    @DisplayName("로또 결과가 4등인지 테스트한다.")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void checkFourthPlace(boolean hasBonus) {
        assertThat(WinningRank.of(4, hasBonus)).isEqualTo(WinningRank.FOURTH);
    }

    @DisplayName("로또 결과가 5등인지 테스트한다.")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void checkFifthPlace(boolean hasBonus) {
        assertThat(WinningRank.of(3, hasBonus)).isEqualTo(WinningRank.FIFTH);
    }

    @DisplayName("로또 결과가 꽝인지 테스트한다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 1, 0})
    void checkMiss(int count) {
        assertThat(WinningRank.of(count, false)).isEqualTo(WinningRank.MISS);
    }
}
