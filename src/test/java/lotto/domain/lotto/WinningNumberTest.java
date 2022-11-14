package lotto.domain.lotto;

import lotto.resource.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumberTest {

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinningNumberByOverSize() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,6,7", "10"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_SIX_COUNT.getValue());
    }

    @DisplayName("당첨 번호의 개수가 6개 보다 적으면 예외가 발생한다.")
    @Test
    void createWinningNumberByUnderSize() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5", "10"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_SIX_COUNT.getValue());
    }

    @DisplayName("당첨 번호의 숫자가 1~45 범위를 넘어가면 예외가 발생한다.")
    @Test
    void createWinningNumberByOutOrRangeNumber() {
        assertThatThrownBy(() -> new WinningNumber("123,2,3,4,5,6", "10"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_BETWEEN_1_AND_45_MESSAGE.getValue());
    }

    @DisplayName("당첨 번호의 숫자가 중복되면 예외가 발생한다.")
    @Test
    void createWinningNumberByDuplicateNumber() {
        assertThatThrownBy(() -> new WinningNumber("1,1,3,4,5,6", "10"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATED_NUMBER.getValue());
    }

    @DisplayName("당첨 번호의 숫자가 양의 정수가 아니거나 정수(Integer)의 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createWinningNumberByNotInteger() {
        assertAll(
                () -> assertThatThrownBy(() ->
                        new WinningNumber("a,1,3,4,5,6", "10"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.NOT_INTEGER_OR_NUMBER_OUT_OF_RANGE_MESSAGE.getValue()),
                () -> assertThatThrownBy(() ->
                        new WinningNumber("1234125115532,1,3,4,5,6", "10"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.NOT_INTEGER_OR_NUMBER_OUT_OF_RANGE_MESSAGE.getValue())
        );
    }

    @DisplayName("보너스 번호의 숫자가 양의 정수가 아니거나 정수(Integer)의 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createBonusNumberByNotInteger() {
        assertAll(
                () -> assertThatThrownBy(() ->
                        new WinningNumber("1,2,3,4,5,6", "ab"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.NOT_INTEGER_OR_NUMBER_OUT_OF_RANGE_MESSAGE.getValue()),
                () -> assertThatThrownBy(() ->
                        new WinningNumber("1,2,3,4,5,6", "123455667778"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.NOT_INTEGER_OR_NUMBER_OUT_OF_RANGE_MESSAGE.getValue())
        );
    }

    @DisplayName("보너스 번호의 숫자가 1~45 범위를 넘어가면 예외가 발생한다.")
    @Test
    void createBonusNumberByOutOrRangeNumber() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,6", "123"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_BETWEEN_1_AND_45_MESSAGE.getValue());
    }

    @DisplayName("보너스 번호의 숫자가 당첨 번호와 중복될 경우 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicateNumberWithLottoNumbers() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,6", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATE_BONUS_NUMBER_AND_LOTTO_NUMBERS.getValue());
    }
}