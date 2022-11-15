package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class VerifierTest {
    @Test
    void validateMoneyTest() {
        String input = "1001";
        assertThatThrownBy(() -> Verifier.validateMoney(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateWinningNumbersTest() {
        String[] input = {"1", "2", "3", "4", "5"};
        assertThatThrownBy(() -> Verifier.validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateBonusNumberTest() {
        String bonusNumber = "1";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> Verifier.validateBonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateLottoNumberTest() {
        String input = "0";
        assertThatThrownBy(() -> Verifier.validateLottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateIntegerTest() {
        String input = "98d";
        assertThatThrownBy(() -> Verifier.validateInteger(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateDuplicateTest() {
        String[] input = {"1", "2", "3", "4", "5", "5"};
        assertThatThrownBy(() -> Verifier.validateDuplicate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}