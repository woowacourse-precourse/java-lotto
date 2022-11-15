package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MatchTest {

    @DisplayName("Match 결과 계산 후 반환 성공")
    @ParameterizedTest
    @CsvSource({
            "5, false, FIVE",
            "3, true, THREE",
            "6, true, SIX",
            "5, true, FIVE_WITH_BONUS",
    })
    void testGetMatch(int countOfWinNumbers, boolean isBonusNumber, Match expectedResult) {
        Match match = Match.getMatch(countOfWinNumbers, isBonusNumber);

        Assertions.assertThat(match).isEqualTo(expectedResult);
    }
}
