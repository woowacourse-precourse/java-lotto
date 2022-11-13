package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumberParserTest {

    private final WinningNumberParser winningNumberParser = new WinningNumberParser();

    @DisplayName("1,2,3,4,5,6 형태의 문자열 값을 받아 List<Integer>로 반환한다.")
    @Test
    void formattedNumberToIntegerList() {
        List<Integer> numbers = winningNumberParser.winningNumbers("1,2,3,4,5,6");
        assertThat(numbers).hasSize(6);
    }

    @ParameterizedTest(name = "양식을 지키지 않으면 예외를 던진다.")
    @ValueSource(strings = {
            "1,2,3,",
            "123456",
            "1,2,3,4,5,6,",
            "1,2,3,4,5,6,7,8"})
    void fail(String inputValue) {
        assertThatThrownBy(
                () -> winningNumberParser.winningNumbers(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("올바른 당첨 번호 포맷이 아닙니다.");
    }
}