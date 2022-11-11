package lotto.service.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryNumberValidationTest {
    @DisplayName("로또 번호 중 각각 숫자가 하나라도 1-45 범위를 벗어나는 경우 false 반환")
    @Test
    void lotteryNumberValidation_check_each_number_range() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 46, 6, 7);
        LotteryNumberValidation validation = new LotteryNumberValidation(winningNumbers);
        boolean result = validation.isValidWinningNumbers();
        boolean EXPECTED_RESULT = false;
        assertThat(result).isEqualTo(EXPECTED_RESULT);
    }

    @DisplayName("로또 번호 개수가 총 6개가 아닌 경우 false 반환")
    @Test
    void lotteryNumberValidation_check_size() {
        List<Integer> winningNumbers = List.of(1, 2, 3);
        LotteryNumberValidation validation = new LotteryNumberValidation(winningNumbers);
        boolean result = validation.isValidWinningNumbers();
        boolean EXPECTED_RESULT = false;
        assertThat(result).isEqualTo(EXPECTED_RESULT);
    }

    @DisplayName("로또 번호 중 중복된 값이 있는 경우 false 반환")
    @Test
    void lotteryNumberValidation_check_unique_value() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 3, 4, 5);
        LotteryNumberValidation validation = new LotteryNumberValidation(winningNumbers);
        boolean result = validation.isValidWinningNumbers();
        boolean EXPECTED_RESULT = false;
        assertThat(result).isEqualTo(EXPECTED_RESULT);
    }


    @DisplayName("올바른 로또 번호를 입력한 경우 true 반환")
    @Test
    void lotteryNumberValidation_check_right_input() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        LotteryNumberValidation validation = new LotteryNumberValidation(winningNumbers);
        boolean result = validation.isValidWinningNumbers();
        boolean EXPECTED_RESULT = true;
        assertThat(result).isEqualTo(EXPECTED_RESULT);
    }

    @DisplayName("보너스 숫자가 범위 내에 있지만 이미 존재하는 당첨 숫자를 입력한 경우 false 반환")
    @Test
    void bonusNumberValidation_check_includesWinningNumber() {
        int BONUS_NUMBER = 3;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6, 7);
        LotteryNumberValidation validation = new LotteryNumberValidation(winningNumbers);
        boolean result = validation.isValidBonusNumber(BONUS_NUMBER);
        boolean EXPECTED_RESULT = false;
        assertThat(result).isEqualTo(EXPECTED_RESULT);
    }

    @DisplayName("보너스 숫자가 범위 내에 없고 당첨숫자들과 다른 새로운 숫자를 입력한 경우 false 반환")
    @Test
    void bonusNumberValidation_check_isRightRange() {
        int BONUS_NUMBER = 46;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6, 7);
        LotteryNumberValidation validation = new LotteryNumberValidation(winningNumbers);
        boolean result = validation.isValidBonusNumber(BONUS_NUMBER);
        boolean EXPECTED_RESULT = false;
        assertThat(result).isEqualTo(EXPECTED_RESULT);
    }


    @DisplayName("보너스 숫자가 범위 내에 있고, 당첨숫자들과 다른 새로운 숫자를 입력한 경우 true 반환")
    @Test
    void bonusNumberValidation_check() {
        int BONUS_NUMBER = 8;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6, 7);
        LotteryNumberValidation validation = new LotteryNumberValidation(winningNumbers);
        boolean result = validation.isValidBonusNumber(BONUS_NUMBER);
        boolean EXPECTED_RESULT = true;
        assertThat(result).isEqualTo(EXPECTED_RESULT);
    }
}
