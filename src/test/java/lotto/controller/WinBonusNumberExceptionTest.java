package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinBonusNumberExceptionTest {

    @DisplayName("당첨 번호 중복 확인")
    @Test
    void winNumberDuplicationTest() {
        List<Integer> wrongWinNumber = new ArrayList<>(Arrays.asList(1,2,3,4,5,5));
        assertThatThrownBy(() -> ExceptionHandler.validateWinNumber(wrongWinNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 범위 확인")
    @Test
    void winNumberRangeTest() {
        List<Integer> wrongWinNumber = new ArrayList<>(Arrays.asList(1,2,3,4,5,46));
        assertThatThrownBy(() -> ExceptionHandler.validateWinNumber(wrongWinNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 범위 확인")
    @Test
    void bonusNumberRangeTest() {
        int wrongBonusNumber = 46;
        assertThatThrownBy(() -> ExceptionHandler.validateBonusNumber(wrongBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
