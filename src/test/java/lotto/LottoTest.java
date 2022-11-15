package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    private final ExceptionHandler exception = new ExceptionHandler();

    @ParameterizedTest
    @CsvSource({"'', '[ERROR] 01'", "'300b', '[ERROR] 02'", "'8200', '[ERROR] 03'"})
    void purchaseAmountException(String input, String expected) {
        assertThatThrownBy(() -> exception.purchaseAmountException(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expected);
    }

    @ParameterizedTest
    @MethodSource("stringList")
    void winningNumbersException(List<String> stringList, String expected) {
        assertThatThrownBy(() -> exception.winningNumbersException(stringList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expected);
    }

    static Stream<Arguments> stringList() {
        return Stream.of(
                Arguments.of(Arrays.asList("11", "37", "4"), "[ERROR] 04"),
                Arguments.of(Arrays.asList("38", "21", "z", "8", "29", "10"), "[ERROR] 06"),
                Arguments.of(Arrays.asList("18", "40", "19", "56", "0", "81"), "[ERROR] 05"),
                Arguments.of(Arrays.asList("22", "23", "11", "27", "9", "9"), "[ERROR] 07")
        );
    }

    @ParameterizedTest
    @MethodSource("winningNum")
    void bonusNumberException(List<Integer> winningNum, String bonusNum, String expected) {
        assertThatThrownBy(() -> exception.bonusNumberException(winningNum, bonusNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expected);
    }

    static Stream<Arguments> winningNum() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,3,5,7,9), "", "[ERROR] 01"),
                Arguments.of(Arrays.asList(1,3,5,7,9), "g", "[ERROR] 02"),
                Arguments.of(Arrays.asList(1,3,5,7,9), "88", "[ERROR] 05"),
                Arguments.of(Arrays.asList(1,3,5,7,9), "5", "[ERROR] 07")
        );
    }
}
