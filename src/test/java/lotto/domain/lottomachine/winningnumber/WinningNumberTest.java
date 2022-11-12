package lotto.domain.lottomachine.winningnumber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberTest {

    @DisplayName("생성자 메소드에 1부터 45범위 안의 숫자가 입력되었을 때 WinningNumber 객체를 생성하는지 확인")
    @ParameterizedTest()
    @ValueSource(ints = {1, 45, 33})
    void constructor_test(int numberInRange) {
        WinningNumber winningNumber = new WinningNumber(numberInRange);

        assertThat(winningNumber).isInstanceOf(WinningNumber.class);
    }

    @DisplayName("생성자 메소드에 1부터 45범위를 초과하는 숫자가 입력되었을 때 오류가 발생하는지 확인")
    @ParameterizedTest()
    @ValueSource(ints = {111, 52, -1})
    void constructor_error_test(int outOfRangeNumber) {
        assertThatThrownBy(() -> new WinningNumber(outOfRangeNumber)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("equals 메소드에 같은 숫자의 다른 객체를 입력했을 때 true를 반환하는지 확인")
    @ParameterizedTest()
    @CsvSource({"1, 1", "2, 2", "3, 3"})
    void equals_true_test(int number, int sameNumber) {
        WinningNumber winningNumber = new WinningNumber(number);
        WinningNumber sameWinningNumber = new WinningNumber(sameNumber);

        assertThat(winningNumber.equals(sameWinningNumber)).isTrue();
    }

    @DisplayName("equals 메소드에 다른 숫자의 객체를 입력했을 때 false를 반환하는지 확인")
    @ParameterizedTest()
    @CsvSource({"1, 2", "2, 3", "5, 3"})
    void equals_false_test(int number, int differentNumber) {
        WinningNumber winningNumber = new WinningNumber(number);
        WinningNumber differentWinningNumber = new WinningNumber(differentNumber);

        assertThat(winningNumber.equals(differentWinningNumber)).isFalse();
    }

    @DisplayName("hashCode 메소드로 같은 숫자의 두 객체를 비교했을 때 서로 같은지 확인")
    @ParameterizedTest()
    @CsvSource({"1, 1", "2, 2", "3, 3"})
    void hashCode_equal_test(int number, int sameNumber) {
        WinningNumber winningNumber = new WinningNumber(number);
        WinningNumber sameWinningNumber = new WinningNumber(sameNumber);

        assertThat(winningNumber.hashCode()).isEqualTo(sameWinningNumber.hashCode());
    }

    @DisplayName("hashCode 메소드로 다른 숫자의 두 객체를 비교했을 때 서로 같은지 확인")
    @ParameterizedTest()
    @CsvSource({"1, 2", "2, 3", "3, 4"})
    void hashCode_not_equal_test(int number, int differentNumber) {
        WinningNumber winningNumber = new WinningNumber(number);
        WinningNumber differentWinningNumber = new WinningNumber(differentNumber);

        assertThat(winningNumber.hashCode()).isNotEqualTo(differentWinningNumber.hashCode());
    }

    @DisplayName("isSameValue 메소드에 값이 같은 숫자를 입력하였을 때 true를 반환하는지 확인")
    @ParameterizedTest()
    @CsvSource({"1, 1", "2, 2", "3, 3"})
    void isSameValue_true_test(int number, int sameNumber) {
        WinningNumber winningNumber = new WinningNumber(number);

        assertThat(winningNumber.isSameValue(sameNumber)).isTrue();
    }

    @DisplayName("isSameValue 메소드에 값이 같은 숫자를 입력하였을 때 false를 반환하는지 확인")
    @ParameterizedTest()
    @CsvSource({"1, 2", "2, 3", "3, 33"})
    void isSameValue_false_test(int number, int sameNumber) {
        WinningNumber winningNumber = new WinningNumber(number);

        assertThat(winningNumber.isSameValue(sameNumber)).isFalse();
    }
}