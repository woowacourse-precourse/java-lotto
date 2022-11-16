package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개를 넘으면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 총 6개여야 합니다.");

    }

    @DisplayName("로또 번호의 개수가 6개보다 적으면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 총 6개여야 합니다.");

    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호에 중복이 없어야 합니다.");

    }

    @ParameterizedTest(name = "로또 번호를 오름차순으로 정렬하여 저장한다")
    @MethodSource
    void sortLottoNumbers(List<Integer> numbers, List<Integer> expected) {
        assertThat(new Lotto(numbers).getNumbers()).isEqualTo(expected);
    }

    private static Stream<Arguments> sortLottoNumbers() {
        return Stream.of(
                Arguments.of(List.of(3, 1, 2, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6)),
                Arguments.of(List.of(43, 1, 24, 2, 11, 5), List.of(1, 2, 5, 11, 24, 43)),
                Arguments.of(List.of(1, 2, 5, 6, 7, 8), List.of(1, 2, 5, 6, 7, 8))
        );

    }

    @ParameterizedTest(name = "로또 번호 중 1 ~ 45가 아닌 수가 있으면 예외가 발생한다.")
    @CsvSource({"0,2,3,4,5,6", "1,2,4,46,6,7"})
    void createLottoByOutOfRangeNumber(int num1, int num2, int num3, int num4, int num5, int num6) {
        List<Integer> numbers = List.of(num1, num2, num3, num4, num5, num6);

        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

}
