package lotto.validation;

import lotto.exception.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberFormValidationTest {

    private LottoNumberFormValidation validation = new LottoNumberFormValidation();

    @Test
    @DisplayName("입력 폼에 공백이 포함되어 있으면 예외 발생")
    void blankIncludeValid() {
        // given
        String writeLottoNumber = "1,2,3,4,5,6 ";
        String writeBonusNumber = "9";

        // when && then
        assertThatThrownBy(() -> validation.blankIncludeValid(writeLottoNumber, writeBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.ERROR.getMessage());
    }

    @Test
    @DisplayName("문자열 데이터에 숫자가 아니면서 로또 번호의 범위에 맞지 않으면 예외 발생")
    void getValidBonusNumber() {
        // given
        String rangeWriteBonusNumber = "46";
        String digitWriteBonusNumber = "a";

        // when && then
        assertThatThrownBy(() -> validation.getValidBonusNumber(rangeWriteBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.ERROR.getMessage());
        assertThatThrownBy(() -> validation.getValidBonusNumber(digitWriteBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.ERROR.getMessage());
    }

    @Test
    @DisplayName("당첨 로또 리스트에 중복된 숫자가 있으면 예외 발생")
    void duplicatedValid() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 3, 4, 5);

        // when && then
        assertThatThrownBy(() -> validation.countValid(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.ERROR.getMessage());
    }

    @Test
    @DisplayName("당첨 로또 리스트의 사이즈가 6개가 아니면 예외 발생")
    void countValid() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        // when && then
        assertThatThrownBy(() -> validation.countValid(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.ERROR.getMessage());
    }
}