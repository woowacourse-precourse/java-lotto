package lotto.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @DisplayName("[예외] 구매 금액이 1,000원 단위가 아닐시에 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {900, 1100, 1114, 12345})
    void validateByInvalidPurchaseAmount(int purchaseAmount) {
        assertThatThrownBy(() -> Validator.validatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("[예외] 당첨 번호와 보너스 번호 중복이 존재하면 예외가 발생한다.")
    @Test
    void validateByDuplication() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        for (Integer bonusNumber : winningNumbers) {
            assertThatThrownBy(() -> Validator.validateLottoNumber(winningNumbers, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.DUPLICATED_NUMBER_MESSAGE.toString());
        }
    }

    @DisplayName("[예외] 당첨 번호의 갯수가 6개가 아닐시에 예외가 발생한다.")
    @Test
    void validateByInvalidSize() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5);
        int bonusNumber = 7;
        assertThatThrownBy(() -> Validator.validateLottoNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_SIZE_MESSAGE.toString());
    }

    @DisplayName("[예외] 당첨 번호의 유효한 범위 이외에 값이 존재하면 예외가 발생한다.")
    @Test
    void validateByInvalidRange() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 46);
        int bonusNumber = 7;
        assertThatThrownBy(() -> Validator.validateLottoNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_RANGE_MESSAGE.toString());
    }
}
