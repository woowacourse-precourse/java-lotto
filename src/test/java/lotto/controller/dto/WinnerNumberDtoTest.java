package lotto.controller.dto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinnerNumberDtoTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,5:9", "3,7,3,4,1,5:9", "1,2,2,4,10,5:40", "10,12,13,14,15,15:9"}, delimiter = ':')
    @DisplayName("당첨번호에 6개중 숫자가 중복일때 예외처리")
    void isWinnerNumberDuplicationTest(String winnerNumber, String bonusNumber) {
        assertThatThrownBy(() -> new WinnerNumberDto(winnerNumber, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"a,2,3,4,10,5:9", "3,7,3a,4,1,5:9", "1,2 ,40,4,10,5:40", "10,-12,13,14,19,15:9"}, delimiter = ':')
    @DisplayName("당첨번호에 6개중 숫자가 정수형태가 아닐때 예외처리")
    void isWinnerNumberIntegerTest(String winnerNumber, String bonusNumber) {
        assertThatThrownBy(() -> new WinnerNumberDto(winnerNumber, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,50,5:9", "3,7,0,4,1,5:9", "1,2,100,4,10,5:40"}, delimiter = ':')
    @DisplayName("당첨번호에 6개중 숫자가 범위 밖에 숫자일때 예외처리")
    void isWinnerNumberRangeTest(String winnerNumber, String bonusNumber) {
        assertThatThrownBy(() -> new WinnerNumberDto(winnerNumber, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,7:5", "3,7,10,4,1,5:10", "1,2,20,4,10,5:20", "10,12,13,14,15,9:9"}, delimiter = ':')
    @DisplayName("당첨번호와 보너스 숫자가 중복일때 예외처리")
    void isBonusNumberDuplicationTest(String winnerNumber, String bonusNumber) {
        assertThatThrownBy(() -> new WinnerNumberDto(winnerNumber, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,7:5a", "3,7,10,4,1,5:-2", "1,2,20,4,10,5:--", "10,12,13,14,15,9:9@"}, delimiter = ':')
    @DisplayName("보너스 숫자가 정수 형태가 아닐시 예외처리")
    void isBonusNumberIntegerTest(String winnerNumber, String bonusNumber) {
        assertThatThrownBy(() -> new WinnerNumberDto(winnerNumber, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,7:50", "3,7,10,4,1,5:111", "1,2,20,4,10,5:0"}, delimiter = ':')
    @DisplayName("보너스 숫자가 숫자가 범위 밖에 숫자일때 예외처리")
    void isBonusNumberRangeTest(String winnerNumber, String bonusNumber) {
        assertThatThrownBy(() -> new WinnerNumberDto(winnerNumber, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
