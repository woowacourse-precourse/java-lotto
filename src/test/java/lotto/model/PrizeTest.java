package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static lotto.model.Prize.FIFTH;
import static lotto.model.Prize.FIRST;
import static lotto.model.Prize.FOURTH;
import static lotto.model.Prize.NONE;
import static lotto.model.Prize.SECOND;
import static lotto.model.Prize.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Prize에 있는 메서드를 테스트한다.")
class PrizeTest {

    @DisplayName("judge 메서드를 테스트한다.")
    @ParameterizedTest
    @MethodSource("judgeTestData")
    void judge(int winningMatches, int bonusMatches, Prize result) {
        assertThat(Prize.judge(winningMatches, bonusMatches)).isEqualTo(result);
    }

    private static Stream<Arguments> judgeTestData() {
        return Stream.of(
                Arguments.of(1, 0, NONE),
                Arguments.of(1, 1, NONE),
                Arguments.of(2, 0, NONE),
                Arguments.of(2, 1, NONE),
                Arguments.of(3, 0, FIFTH),
                Arguments.of(3, 1, FIFTH),
                Arguments.of(4, 0, FOURTH),
                Arguments.of(4, 1, FOURTH),
                Arguments.of(5, 0, THIRD),
                Arguments.of(5, 1, SECOND),
                Arguments.of(6, 0, FIRST),
                Arguments.of(6, 1, FIRST)
        );
    }
}