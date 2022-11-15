package lotto.domain;

import lotto.util.Input;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberTest {

    private static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @DisplayName("당첨 번호가 모두 제대로 존재한다.")
    @Test
    void createWinningNumber() {
        WinningNumber numbers = WinningNumber.draw(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> testNumbers = List.of(6, 4, 3, 1, 5, 2);

        assertThat(testNumbers.stream().allMatch(numbers::hasNumber))
                .isTrue();
    }

    @DisplayName("당첨 번호 입력이 형식에 맞지 않으면 예외가 발생한다.")
    @Test
    void createWinningNumberByInvalidFormat() {
        InputStream in = generateUserInput("1,2,3,4,5,");
        System.setIn(in);

        assertThatThrownBy(Input::inputWinningNumbers)
                .hasMessageContaining("[ERROR] 당첨 번호의 입력이 올바르지 않습니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 숫자가 1~45가 아니면 예외가 발생한다.")
    @Test
    void createWinningNumberByOutOfRangeNumber() {
        assertThatThrownBy(() -> WinningNumber.draw(List.of(1,2,3,4,5,46)))
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호들 중 숫자가 중복되면 예외가 발생한다.")
    @Test
    void createWinningNumberByDuplicatedNumber() {
        assertThatThrownBy(() -> WinningNumber.draw(List.of(1,2,3,4,5,5)))
                .hasMessageContaining("[ERROR] 당첨 번호들 중 중복된 숫자가 있습니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 제대로 생성되었다.")
    @Test
    void createBonusNumber() {
        WinningNumber winningNumber = WinningNumber.draw(List.of(1, 2, 3, 4, 5, 6));
        winningNumber.addBonus(7);

        assertThat(winningNumber.getBonus()).isEqualTo(7);
    }

    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void createBonusNumberByNotNumber() {
        InputStream in = generateUserInput("a7");
        System.setIn(in);

        assertThatThrownBy(Input::inputBonusNumber)
                .hasMessageContaining("[ERROR] 보너스 번호의 입력이 올바르지 않습니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 숫자가 1~45가 아니면 예외가 발생한다.")
    @Test
    void createBonusNumberByOutOfRangeNumber() {
        assertThatThrownBy(() -> WinningNumber.draw(List.of(1,2,3,4,5,6)).addBonus(46))
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicatedNumberWithWinningNumber() {
        assertThatThrownBy(() -> WinningNumber.draw(List.of(1,2,3,4,5,6)).addBonus(6))
                .hasMessageContaining("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }
}