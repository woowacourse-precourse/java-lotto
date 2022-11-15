package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PrizeTest {
    private static Stream<Arguments> provideUserWinNumber() {
        return Stream.of(
                Arguments.of(1,false,Prize.FAIL),
                Arguments.of(3,false,Prize.FIFTH),
                Arguments.of(5,true,Prize.SECOND),
                Arguments.of(6,false,Prize.FIRST)
        );
    }

    @DisplayName("정답 갯수와 보너스 번호 당첨 여부에 따라 순위를 반환한다")
    @ParameterizedTest
    @MethodSource("provideUserWinNumber")
    void isWinNumberInvalid(int correctCount,boolean correctBonus,Prize expectedRank) {
        assertThat(Prize.makingResult(correctCount,correctBonus)).isEqualTo(expectedRank);
    }

    @DisplayName("맞춘 번호가 6을 초과할시 예외가 발생한다.")
    @Test
    void correctNumberOverSixInvokeException() {
        assertThatThrownBy(() -> Prize.makingResult(7,false).getCorrectCount())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
