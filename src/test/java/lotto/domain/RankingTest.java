package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class RankingTest {

    @DisplayName("입력에 따라 등수를 생성해서 반환하는 기능")
    @ParameterizedTest
    @CsvSource(value = {
            "0, false, MISS",
            "0, true, MISS",
            "1, false, MISS",
            "1, true, MISS",
            "2, false, MISS",
            "2, true, MISS",
            "3, false, FIFTH",
            "3, true, FIFTH",
            "4, false, FOURTH",
            "4, true, FOURTH",
            "5, false, THIRD",
            "5, true, SECOND",
            "6, false, FIRST"})
    void createRankTest(int matchCount, boolean bonus, String expected) {
        String actual = Ranking.of(matchCount, bonus).name();
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> createArgumentsForRankTest() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(winningLotto, 7);
        return Stream.of(
                Arguments.of(winningLotto, bonusNumber, new Lotto(List.of(1, 12, 13, 14, 15, 16)), "MISS"),
                Arguments.of(winningLotto, bonusNumber, new Lotto(List.of(1, 2, 13, 14, 15, 16)), "MISS"),
                Arguments.of(winningLotto, bonusNumber, new Lotto(List.of(1, 2, 3, 14, 15, 16)), "FIFTH"),
                Arguments.of(winningLotto, bonusNumber, new Lotto(List.of(1, 2, 3, 4, 15, 16)), "FOURTH"),
                Arguments.of(winningLotto, bonusNumber, new Lotto(List.of(1, 2, 3, 4, 5, 16)), "THIRD"),
                Arguments.of(winningLotto, bonusNumber, new Lotto(List.of(1, 2, 3, 4, 5, 7)), "SECOND"),
                Arguments.of(winningLotto, bonusNumber, new Lotto(List.of(1, 2, 3, 4, 5, 6)), "FIRST")
        );
    }

    @DisplayName("등수 매기는 기능 테스트")
    @ParameterizedTest
    @MethodSource("createArgumentsForRankTest")
    void rankTest(Lotto winningLotto, BonusNumber bonusNumber, Lotto lotto, String expected) {
        String actual = Ranking.rank(lotto, winningLotto, bonusNumber).name();
        assertThat(actual).isEqualTo(expected);
    }
}
