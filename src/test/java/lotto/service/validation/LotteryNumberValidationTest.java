package lotto.service.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryNumberValidationTest {

    @DisplayName("보너스 숫자가 범위 내에 있지만 이미 존재하는 당첨 숫자를 입력한 경우 false 반환")
    @Test
    void BonusNumberValidation_check_includesWinningNumber() {
        int BONUS_NUMBER = 3;
        boolean EXPECTED_RESULT = false;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6, 7);
        LotteryNumberValidation validation = new LotteryNumberValidation(winningNumbers);
        boolean result = validation.isValidBonusNumber(BONUS_NUMBER);
        assertThat(result).isEqualTo(EXPECTED_RESULT);
    }

    @DisplayName("보너스 숫자가 범위 내에 없고 당첨숫자들과 다른 새로운 숫자를 입력한 경우 false 반환")
    @Test
    void BonusNumberValidation_check_isRightRange() {
        int BONUS_NUMBER = 46;
        boolean EXPECTED_RESULT = false;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6, 7);
        LotteryNumberValidation validation = new LotteryNumberValidation(winningNumbers);
        boolean result = validation.isValidBonusNumber(BONUS_NUMBER);
        assertThat(result).isEqualTo(EXPECTED_RESULT);
    }


    @DisplayName("보너스 숫자가 범위 내에 있고, 당첨숫자들과 다른 새로운 숫자를 입력한 경우 true 반환")
    @Test
    void BonusNumberValidation_check() {
        int BONUS_NUMBER = 8;
        boolean EXPECTED_RESULT = true;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6, 7);
        LotteryNumberValidation validation = new LotteryNumberValidation(winningNumbers);
        boolean result = validation.isValidBonusNumber(BONUS_NUMBER);
        assertThat(result).isEqualTo(EXPECTED_RESULT);
    }
}
