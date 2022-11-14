package lotto.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static lotto.constant.Message.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidatorTest {

    private final Validator validator = new Validator();

    @Test
    void 당첨_번호_범위_초과_시_예외_처리() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> validator.validateWinningLotto(
                        List.of(46, 1, 2, 34, 7, 8)
                ));

        assertEquals(exception.getMessage(), ERROR_MESSAGE + INVALID_NUMBER_INPUT_FORMAT_MESSAGE);
    }

    @Test
    void 당첨_번호_중복_시_예외_처리() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> validator.validateWinningLotto(
                        List.of(1, 1, 2, 34, 7, 8)
                ));

        assertEquals(exception.getMessage(), ERROR_MESSAGE + DUPLICATE_LOTTO_NUMBER_MESSAGE);
    }

    @Test
    void 보너스_번호_숫자_아닐_시_예외_처리() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> validator.validateBonusNumber(
                        List.of(45, 1, 2, 34, 7, 8), "a"
                ));

        assertEquals(exception.getMessage(), ERROR_MESSAGE + INPUT_NOT_DIGIT);
    }

    @Test
    void 보너스_번호_중복_시_예외_처리() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> validator.validateBonusNumber(
                        List.of(9, 1, 2, 34, 7, 8), "1"
                ));

        assertEquals(exception.getMessage(), ERROR_MESSAGE + DUPLICATE_LOTTO_NUMBER_MESSAGE);
    }

    @Test
    void 구매_금액_숫자_아닐_시_예외_처리() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> validator.validatePurchasedAmount("a"));

        assertEquals(exception.getMessage(), ERROR_MESSAGE + INPUT_NOT_DIGIT);
    }

    @Test
    void 구입_금액_1000원_단위_아닐_시_예외_처리() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> validator.validatePurchasedAmount("2200"));

        assertEquals(exception.getMessage(), ERROR_MESSAGE + INVALID_MONEY_UNIT_INPUT_MESSAGE);
    }

}
