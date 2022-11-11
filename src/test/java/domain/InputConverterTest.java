package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static util.Constant.*;

class InputConverterTest {

    @DisplayName("금액 입력 변환 테스트")
    @Test
    void getMoney() {
        String moneyInput = "1000";
        int money = InputConverter.getMoney(moneyInput);
        Assertions.assertThat(money).isEqualTo(1000);
    }

    @DisplayName("당첨 번호 변환 테스트")
    @Test
    void getWinningNumbers() {
        String winningNumbersInput = "1,2,3,4,5,6";
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = InputConverter.getWinningNumbers(winningNumbersInput);

        for (int i = 0; i < 6; i++) {
            Assertions.assertThat(numbers.get(i)).isEqualTo(winningNumbers.get(i));
        }

    }

    @DisplayName("번호 변환 테스트")
    @Test
    void getNumber() {
        String bonusNumberInput = "7";
        int bonusNumber = InputConverter.getNumber(bonusNumberInput);

        Assertions.assertThat(bonusNumber).isEqualTo(7);
    }

    @DisplayName("구매 금액에 숫자가 아닌 값이 포함되어 있으면 예외가 발생한다.")
    @Test
    void enterNotNumeralMoney() {
        String money = "1000a";
        Assertions.assertThatThrownBy(() -> InputConverter.getMoney(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액에 숫자가 아닌 값이 포함되어 있습니다.");
    }

    @DisplayName("구매 금액의 단위가 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void enterNotValidMoneyUnit() {
        String money = "1001";
        Assertions.assertThatThrownBy(() -> InputConverter.getMoney(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1000원 단위로 입력되어야 합니다.");
    }

    @DisplayName("보너스 숫자에 숫자가 아닌 값이 입력되면 에외가 발생한다.")
    @Test
    void enterNotNumeralBonusNumber() {
        String bonusNumber = "a";
        Assertions.assertThatThrownBy(() -> InputConverter.getNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 숫자가 숫자가 아닌 값으로 입력되었습니다.");
    }

    @DisplayName("보너스 숫자가 범위 외의 숫자인 경우 예외가 발생한다.")@Test
    void enterOutBoundBonusNumber() {
        String bonusNumber = "46";
        Assertions.assertThatThrownBy(() -> InputConverter.getNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1~45 범위의 숫자여야 합니다.");
    }
}
