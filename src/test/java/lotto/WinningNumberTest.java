package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class WinningNumberTest {

    @DisplayName("범위 확인 테스트 - 정상 테스트")
    @Test
    void givenList_whenValidateForRange_thenNothingHappen() {
        //Given
        List<Integer> list = List.of(1, 2, 4, 45, 13);

        //When
        Throwable t = catchThrowable(() -> Validator.validateForRange(list));

        //Then
        assertThat(t).doesNotThrowAnyException();
    }

    @DisplayName("범위 확인 테스트 - 범위 오류")
    @Test
    void givenList_whenValidateForRange_thenThrowException() {
        //Given
        List<Integer> list = List.of(1, 2, 4, 46, 1);

        //When
        Throwable t = catchThrowable(() -> Validator.validateForRange(list));

        //Then
        assertThat(t)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(OUT_OF_RANGE_ERROR_MESSAGE);
    }

    @DisplayName("사용자 입력 확인 테스트 - 정상 테스트")
    @Test
    void givenString_whenInputValue_thenReturnList() {
        //Given
        String input = "2,6,15,22,33,34";

        //When
        List<Integer> list = inputWinningNumber(input);
        //Then
        assertThat(list).isEqualTo(List.of(2, 6, 15, 22, 33, 34));

    }

    @DisplayName("사용자 입력 확인 테스트 - 문자 오류")
    @Test
    void givenString_whenInputValue_thenThrowIllegalException1() {
        //Given
        String input = "22,33,15,eq,34,2";

        //When
        Throwable t = catchThrowable(() -> inputWinningNumber(input));
        //Then
        assertThat(t)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_INPUT_ERROR_MESSAGE);


    }

    @DisplayName("사용자 입력 확인 테스트 - 범위 오류")
    @Test
    void givenString_whenInputValue_thenThrowIllegalException2() {
        //Given
        String input = "22,33,15,6,46,2";

        //When
        Throwable t = catchThrowable(() -> inputWinningNumber(input));
        //Then
        assertThat(t)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(OUT_OF_RANGE_ERROR_MESSAGE);

    }

    @DisplayName("보너스 번호 중복 확인 - 정상")
    @Test
    void givenLotto_whenInputBonusNumber_thenDoesNothing() {
        //Given
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        //When
        Throwable t = catchThrowable(() -> Validator.validateForDuplicatedNumber(winningNumber, bonusNumber));

        //Then
        assertThat(t).doesNotThrowAnyException();
    }

    @DisplayName("보너스 번호 중복 확인 - 비정상")
    @Test
    void givenLotto_whenInputBonusNumber_thenthrowException() {
        //Given
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        //When
        Throwable t = catchThrowable(() -> Validator.validateForDuplicatedNumber(winningNumber, bonusNumber));

        //Then
        assertThat(t)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATED_NUMBER_ERROR_MESSAGE);
    }

    private List<Integer> inputWinningNumber(String input) {
        List<Integer> winningNumber = new ArrayList<>();
        String[] inputList = input.split(",");

        Validator.validateForIllegalInput(inputList);

        for (int i = 0; i < inputList.length; i++) {
            int num = Integer.parseInt(inputList[i]);
            winningNumber.add(num);
        }

        Validator.validateForRange(winningNumber);
        return winningNumber;
    }


}
