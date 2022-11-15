package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParsingUtilsTest {
    @DisplayName("정수로 이루어진 문자열을 정수로 변환한다.")
    @Test
    void stringToInt() {
        String input = " 15";
        int number = 15;

        assertThat(ParsingUtils.stringToInt(input)).isEqualTo(number);
    }

    @DisplayName("정수가 아닌 문자열을 정수로 변환하면 예외가 발생한다.")
    @Test
    void stringToIntByNotInteger() {
        String input = "a5";

        assertThatThrownBy(() -> ParsingUtils.stringToInt(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("쉼표로 구분된 정수 문자열을 정수 리스트로 변환한다.")
    @Test
    void stringToNumbers() {
        String input = "1, 2, 3 , 4,5, 6";
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        assertThat(ParsingUtils.stringToNumbers(input)).isEqualTo(numbers);
    }
}