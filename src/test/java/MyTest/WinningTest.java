package MyTest;

import lotto.domain.Winning;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningTest {

    @DisplayName("정상 입력")
    @Test
    void winning_normalStateTest() {
        //given
        String winningInput = "1,2,38,4,5,6";
        String bonusInput = "19";
        Winning winning = new Winning(winningInput, bonusInput);
        //when
        List<Integer> winningNumber = winning.getWinningNumber();
        int bonusNumber = winning.getBonusNumber();
        //then
        assertThat(winningNumber.toString()).isEqualTo("[1, 2, 38, 4, 5, 6]");
        assertThat(bonusNumber).isEqualTo(19);
    }

    @DisplayName("[당첨번호] 문자 입력시 예외 발생")
    @Test
    void winning_includeCharacterTest() {
        //given
        String winningInput = "1,d,38,4,5,6";
        //then
        assertThatThrownBy(()-> Winning.validateWinningNumberInput(winningInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("[당첨번호] 구분자 콤마 아닌 다른 문자 예외 발생")
    @Test
    void winning_otherSeparationCharacterTest() {
        //given
        String input1 = "1.20.38.4.5.6";
        //then
        assertThatThrownBy(()->Winning.validateWinningNumberInput(input1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("[당첨번호] 입력 길이 벗어날 경우 예외 발생")
    @Test
    void winning_inputLengthTest() {
        //given
        String input = "1,20,38,4,5,6,9,15";
        //then
        assertThatThrownBy(()-> Winning.validateWinningNumberInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("[당첨 번호]에 중복이 있을 경우 예외 발생")
    @Test
    void winning_duplicatedNumberTest() {
        //given
        String input = "1,1,32,43,22,11";
        //then
        assertThatThrownBy(()-> Winning.validateWinningNumberInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("[당첨 번호] 1-45범위 벗어난 입력시 예외 발생")
    @Test
    void winning_inputNumberOutOfBoundTest() {
        //Test1
        String input1 = "1,11,32,46,22,32";
        assertThatThrownBy(()-> Winning.validateWinningNumberInput(input1))
                .isInstanceOf(IllegalArgumentException.class);

        //Test2
        String input2 = "0,11,32,46,22,32";
        assertThatThrownBy(()-> Winning.validateWinningNumberInput(input2))
                .isInstanceOf(IllegalArgumentException.class);

        //Test3
        String input3 = "-12,11,32,46,22,32";
        assertThatThrownBy(()-> Winning.validateWinningNumberInput(input2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("[보너스 번호] 문자 입력시 예외 발생")
    @Test
    void bonus_includeCharacterTest() {
        //given
        String input = "12f";
        //then
        assertThatThrownBy(()-> Winning.validate(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("[보너스 번호] 범위를 벗어난 입력시 예외 발생")
    @Test
    void bonus_inputNumberOutOfBoundTest() {
        //Test 1
        String input1 = "0";
        assertThatThrownBy(()-> Winning.validate(input1)).isInstanceOf(IllegalArgumentException.class);

        //Test 2
        String input2 = "-46";
        assertThatThrownBy(()-> Winning.validate(input2)).isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("[보너스 번호] 공백 입력시 예외 발생")
    @Test
    void bonus_blankInputTest() {
        //given
        String input = "";
        //then
        assertThatThrownBy(()-> Winning.validate(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
