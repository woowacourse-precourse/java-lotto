package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MatchCountTest {

    @DisplayName("당첨번호 등수 반환 테스트")
    @ParameterizedTest(name = "{index}: {5}")
    @MethodSource("isSameResultTest")
    void 테스트(int winningCount1, int bonusCount1, int winningCount2, int bonusCount2, boolean expected, String message) {
        MatchCount matchCount1 = new MatchCount(winningCount1, bonusCount1);
        MatchCount matchCount2 = new MatchCount(winningCount2, bonusCount2);

        assertThat(matchCount1.isSameResult(matchCount2)).isEqualTo(expected);
    }

    private static Stream<Arguments> isSameResultTest() {
        return Stream.of(
                Arguments.of(3, 0, 3, 1, true, "번호 3개일치와 번호3개일치+보너스1개일치의 등수는 같아야 한다."),
                Arguments.of(4, 0, 4, 1, true, "번호 4개일치와 번호4개일치+보너스1개일치의 등수는 같아야 한다."),
                Arguments.of(5, 0, 5, 1, false, "번호 5개일치와 번호5개일치+보너스1개일치의 등수는 달라야 한다."),
                Arguments.of(5, 1, 6, 0, false, "번호 5개일치+보너스1개일치와 당첨번호6개일치의 등수는 달라야 한다.")

        );
    }

    @DisplayName("보너스 개수가 2개 이상일 경우 에러가 발생한다.")
    @Test
    void createMatchCountError_bonus() {
        assertThatThrownBy(() -> new MatchCount(2, 2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("결과 생성 오류 테스트 당첨 개수과 보너스 개수는 합해서 6개를 넘을 수 없다.")
    @Test
    void createMatchCountError_over() {
        assertThatThrownBy(() -> new MatchCount(6, 1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new MatchCount(5, 2))
                .isInstanceOf(IllegalArgumentException.class);
    }
}