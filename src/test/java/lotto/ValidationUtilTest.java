package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidationUtilTest {


    /**
     * validateWinnerNumberContainsComma(param1)
     * param1: String userInput: 사용자 입력 당첨 번호
     * returns 사용자 입력 userInput 반환
     * throws IllegalArgumentException when 쉽표로 구분되지 않은 입력
     */

    @DisplayName("사용자는 당첨번호를 쉽표로 구분하여 입력해야 한다.")
    @Test
    public void validateWinnerNumberContainsCommaTest() {
        //given
        String userInput = "1,2,3,4,5,6";
        String expectedValue = "1,2,3,4,5,6";
        //when
        String actualValue = ValidationUtil.validateWinnerNumberContainsComma(userInput);

        //then
        assertEquals(expectedValue, actualValue);
    }

    @DisplayName("사용자는 당첨 번호를 쉽표로 구분하여 입력하지 않은 경우에는 IAE 예외 발생한다.")
    @Test
    public void validateWinnerNumberContainsCommaTest_ExceptionCase() {
        //given
        String userInputWithBlank = "1 2 3 4 5 6";
        //when

        //then
        assertThatThrownBy(() -> ValidationUtil.validateWinnerNumberContainsComma(userInputWithBlank))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /**
     * validateWinnerNumberSize(param1)
     * param1: String userInput
     * returns 사용자 입력 userInput 반환
     * throws IllegalArgumentException when 입력 수가 6개가 되지 않은 경우
     */
    @DisplayName("사용자는 당첨번호 6개를 입력해야 한다.")
    @Test
    public void validateWinnerNumberSizeTest() {
        //given
        String userInput = "1,2,3,4,5,6";
        String expectedValue = "1,2,3,4,5,6";

        //when
        String actualValue = ValidationUtil.validateWinnerNumberSize(userInput);

        //then
        assertEquals(expectedValue, actualValue);
    }

    @DisplayName("쉼표로 구분한 사용자 입력이 6개가 아닐 시 예외가 발생한다.")
    @Test
    public void validateWinnerNumberSizeTest_ExceptionCase() {
        //given
        String userInput = "1,2,3,4,5";
        //when

        //then
        assertThatThrownBy(() -> ValidationUtil.validateWinnerNumberSize(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }


    /**
     * validateWinnerNumberRange(param1)
     * param1: List<Integer> winnerNumber
     * throws IllegalArgumentException when 당첨금액의 수가 1~45 범위를 벗어나는 경우
     */
    @DisplayName("사용자 입력한 당첨금액의 수가 1~45 범위를 벗어나면 예외가 발생해야 한다.")
    @Test
    public void validateWinnerNumberRangeTest() {
        //given
        List<Integer> winnerNumber = Arrays.asList(1, 2, 3, 4, 5, 56);
        //when

        //then
        assertThatThrownBy(() -> ValidationUtil.validateWinnerNumberRange(winnerNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /**
     * validateBonusNumberRange(param1)
     * param1: int bonusNumber: 사용자가 입력한 보너스 번호
     * throws IllegalArgumentException when 보너스 번호가 1~45 범위를 벗어나는 경우
     */
    @DisplayName("사용자가 입력한 보너스 번호의 수가 1~45 범위를 벗어나면 예외가 발생해야 한다.")
    @Test
    public void validateBonusNumberRangeTest() {
        //given
        int bonusNumber = 46;
        //when

        //then
        assertThatThrownBy(() -> ValidationUtil.validateBonusNumberRange(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 입력한 보너스 번호가 이미 당첨 번호에 존재할 시 예외가 발생한다.")
    @Test
    public void validateBonusNumberIfExistInWinnerNumberTest() {
        //given
        List<Integer> winnerNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto winnerLotto = new Lotto(winnerNumber);
        int bonusNumber = 6;

        //when

        //then
        assertThatThrownBy(() -> ValidationUtil.validateBonusNumberIfExistInWinnerNumber(winnerLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
