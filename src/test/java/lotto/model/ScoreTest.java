package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreTest {

    @DisplayName("정적 메서드를 통한 인스턴스 생성하기")
    @Test
    void of() {
        Score score1 = new Score(5, 1);
        Score score2 = Score.of(5, 1);

        assertThat(score1.equals(score2)).isTrue();
    }

    @DisplayName("보너스 번호 여부 확인하기")
    @Test
    void hasBonusNumber() {
        Score score = new Score(5, 1);

        assertThat(score.hasBonusNumber()).isTrue();
    }

    @ParameterizedTest(name = "객체가 동등한지 확인하기")
    @MethodSource("testData")
    void testEquals(Score score, Score other, boolean result) {
        assertThat(score.equals(other)).isEqualTo(result);
    }

    @ParameterizedTest(name = "해쉬코드가 동등한지 확인하기")
    @MethodSource("testData")
    void testHashCode(Score score, Score other, boolean result) {
        assertThat(score.hashCode() == other.hashCode()).isEqualTo(result);
    }

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(Score.of(5, 0), Score.of(5, 0), true),
                Arguments.of(Score.of(5, 0), Score.of(5, 1), false)
        );
    }
}