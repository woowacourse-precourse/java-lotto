package lotto.domain.lottomachine.winningnumber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class WinningNumbersTest {

    @DisplayName("생성자 메소드에 중복이 없는 WinningNumber리스트가 입력되면 객체가 생성되는지 확인")
    @ParameterizedTest()
    @MethodSource("provideNonDuplicateListForTest")
    void constructor_test(List<Integer> numbers) {
        WinningNumbers winningNumbers = new WinningNumbers(numbers.stream()
                .map(WinningNumber::new)
                .collect(Collectors.toList()));

        assertThat(winningNumbers).isInstanceOf(WinningNumbers.class);
    }

    @DisplayName("생성자 메소드에 중복이 있는 WinningNumber리스트가 입력되면 오류가 발생하는지 확인")
    @ParameterizedTest()
    @MethodSource("provideDuplicateListForErrorTest")
    void constructor_error_test(List<Integer> numbers) {
        List<WinningNumber> winningNumbers = numbers.stream()
                .map(WinningNumber::new)
                .collect(Collectors.toList());

        assertThatThrownBy(() -> new WinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨번호는 중복될 수 없습니다.");
    }

    @DisplayName("contains 메소드에 WinningNumber 리스트가 입력되면 중복 여부를 반환하는지 확인")
    @ParameterizedTest()
    @MethodSource("provideListForErrorTest")
    void contains_test(List<Integer> numbers, int number, boolean actualValue) {
        WinningNumbers winningNumbers = new WinningNumbers(numbers.stream()
                .map(WinningNumber::new)
                .collect(Collectors.toList()));

        boolean expectedValue = winningNumbers.contains(number);

        assertThat(expectedValue).isEqualTo(actualValue);
    }

    static Stream<Arguments> provideNonDuplicateListForTest() {
        return Stream.of(
                Arguments.of(List.of(1,2,3,4,5,6)),
                Arguments.of(List.of(1,6,2,19,34,25)),
                Arguments.of(List.of(1,2,33,24,45,16))
        );
    }

    static Stream<Arguments> provideDuplicateListForErrorTest() {
        return Stream.of(
                Arguments.of(List.of(1,1,1,4,5,6)),
                Arguments.of(List.of(45,6,45,19,34,25)),
                Arguments.of(List.of(1,2,2,24,45,16))
        );
    }

    static Stream<Arguments> provideListForErrorTest() {
        return Stream.of(
                Arguments.of(List.of(1,2,3,4,5,6), 1, true),
                Arguments.of(List.of(45,6,44,19,34,25), 1, false),
                Arguments.of(List.of(1,2,5,24,45,16), 5, true)
        );
    }
}