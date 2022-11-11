package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
}
