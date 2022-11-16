package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class WinningNumbersTest {
    private static WinningNumbers winningNumber = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

    @ParameterizedTest(name = "유효하지 않은 숫자가 포함되어있으면 오류 발생")
    @MethodSource
    void constructor(List<Integer> mainDraw, int bonus) {
        assertThatThrownBy(() -> new WinningNumbers(mainDraw, bonus))
                .isInstanceOf(IllegalArgumentException.class);

    }

    static Stream<Arguments> constructor() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(List.of(1, 2, 3, 4, 5, 5), 7),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 46));
    }

    @ParameterizedTest(name = "복권 추첨 번호에 숫자가 포함되어있는지 확인한다")
    @CsvSource({"7,false", "6,true", "45,false", "-1,false"})
    void mainDrawContains(int number, boolean expected) {
        assertThat(winningNumber.mainDrawContains(number)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "복권 추첨 번호에 숫자가 포함되어있는지 확인한다")
    @CsvSource({"7,true", "6,false", "45,false", "-1,false"})
    void isEqualToBonusNumbers(int number, boolean expected) {
        assertThat(winningNumber.isEqualToBonusNumbers(number)).isEqualTo(expected);
    }
}