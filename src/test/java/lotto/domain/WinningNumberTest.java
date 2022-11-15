package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

public class WinningNumberTest {
    @DisplayName("당첨 번호를 생성한다.")
    @Test
    void createCorrectWinningNumber() {
        List<Integer> numbers = List.of(1, 2, 30, 45, 5, 29);
        int bonusNumber = 7;
        WinningNumber winningNumber = new WinningNumber(numbers, bonusNumber);

        assertThat(winningNumber.getNumbers()).isEqualTo(numbers);
        assertThat(winningNumber.getBonusNumber()).isEqualTo(bonusNumber);
    }

    @DisplayName("범위를 벗어난 보너스 번호로 당첨 번호 생성시 에러가 발생한다.")
    @Test
    void createWinningNumberWithOutOfRangeBonusNumber() {
        List<Integer> numbers = List.of(1, 2, 30, 7, 5, 29);
        int bonusNumber = 46;

        assertThatThrownBy(() -> new WinningNumber(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1부터 45까지");
    }

    @DisplayName("6자리 숫자와 중복되는 보너스 번호로 당첨 번호 생성시 에러가 발생한다.")
    @Test
    void createWinningNumberWithDuplicateNumber() {
        List<Integer> numbers = List.of(1, 2, 30, 7, 5, 29);
        int bonusNumber = 7;

        assertThatThrownBy(() -> new WinningNumber(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 숫자는 당첨 번호와 중복되지 않아야 합니다.");
    }

    @DisplayName("6개보다 적은 숫자로 당첨 번호 생성 시 에러가 발생한다.")
    @Test
    void createWinningNumberWithLessThanSixNumbers() {
        List<Integer> numbers = List.of(1, 2, 30, 7, 5);
        int bonusNumber = 7;

        assertThatThrownBy(() -> new WinningNumber(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("6개의 숫자를 입력해주세요.");
    }
}
