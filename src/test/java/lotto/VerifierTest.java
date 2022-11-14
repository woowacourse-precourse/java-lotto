package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class VerifierTest {
    @Test
    void isValidMoneyTest() {
        String input = "987";
        boolean result = false;
        assertThat(Verifier.isValidMoney(input)).isEqualTo(result);
    }

    @Test
    void isIntegerTest() {
        String input = "78d";
        boolean result = false;
        assertThat(Verifier.isInteger(input)).isEqualTo(result);
    }

    @Test
    void hasDuplicateTest() {
        String[] input = {"1", "2", "3", "4", "5", "5"};
        boolean result = true;
        assertThat(Verifier.hasDuplicate(input)).isEqualTo(result);
    }

    @Test
    void isValidNumberTest() {
        String input = "0";
        boolean result = false;
        assertThat(Verifier.isValidLottoNumber(input)).isEqualTo(result);
    }

    @Test
    void isValidWinningNumbersTest() {
        String[] input = {"1", "2", "3", "4", "5"};
        boolean result = false;
        assertThat(Verifier.isValidWinningNumbers(input)).isEqualTo(result);
    }

    @Test
    void isValidBonusNumberTest() {
        String input = "6";
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        boolean result = false;
        assertThat(Verifier.isValidBonusNumber(input, winningNumbers)).isEqualTo(result);
    }
}