package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumbersTest {
    @Test
    void winningNumberInputTest() throws Exception {
        WinningNumbers winningNumbers = new WinningNumbers();

        Integer[] input = {1,2,3,4,5,6};
        winningNumbers.newWinningNumbers(new ArrayList<>(List.of(input)));

        Field winningNumbersField = WinningNumbers.class.getDeclaredField("winningNumbers");
        winningNumbersField.setAccessible(true);
        Lotto winningLotto = (Lotto) winningNumbersField.get(winningNumbers);

        for (int index = 0; index < input.length; index++) {
            assertThat(winningLotto.findLottoNumber(index))
                    .isEqualTo(input[index]);
        }
    }

    @Test
    void winningNumberInputExceptionTest() throws Exception {
        WinningNumbers winningNumbers = new WinningNumbers();

        Integer[] input1 = {1,2,3,4,5,6,7};
        Integer[] input2 = {1,2,3,4,5};
        Integer[] input3 = {1,1,1,2,2,2};
        Integer[] input4 = {1,2,3,4,5,50};

        assertThatThrownBy(() ->
                winningNumbers.newWinningNumbers(new ArrayList<>(List.of(input1))))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->
                winningNumbers.newWinningNumbers(new ArrayList<>(List.of(input2))))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->
                winningNumbers.newWinningNumbers(new ArrayList<>(List.of(input3))))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->
                winningNumbers.newWinningNumbers(new ArrayList<>(List.of(input4))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void bonusNumberInputTest() throws Exception {
        WinningNumbers winningNumbers = new WinningNumbers();

        int testNumber = 7;
        winningNumbers.newBonusNumber(testNumber);

        Field bonusNumberField = WinningNumbers.class.getDeclaredField("bonusNumber");
        bonusNumberField.setAccessible(true);
        int bonusNumber = (int) bonusNumberField.get(winningNumbers);

        assertThat(bonusNumber).isEqualTo(testNumber);
    }

    @Test
    void bonusNumberInputExceptionTest() throws Exception {
        WinningNumbers winningNumbers = new WinningNumbers();

        int testNumber1 = 0;
        int testNumber2 = 50;

        assertThatThrownBy(() -> winningNumbers.newBonusNumber(testNumber1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> winningNumbers.newBonusNumber(testNumber2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void bonusNumberDuplicateTest() throws Exception {
        WinningNumbers winningNumbers = new WinningNumbers();

        Integer[] inputLotto = {1,2,3,4,5,6};
        int bonusNumber= 1;
        winningNumbers.newWinningNumbers(new ArrayList<>(List.of(inputLotto)));

        assertThatThrownBy(() -> winningNumbers.newBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}