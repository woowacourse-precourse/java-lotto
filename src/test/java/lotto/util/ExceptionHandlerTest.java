package lotto.util;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.util.ExceptionHandler.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ExceptionHandlerTest {

    @Test
    void validateLottoNumbersSizeTest() {
        assertThatThrownBy(() -> validateLottoNumbers(List.of(1,2,3,4,5)))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void validateLottoNumbersRangeTest() {
        assertThatThrownBy(() -> validateLottoNumbers(List.of(1,2,3,4,5,46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateLottoNumberDuplicationTest() {
        assertThatThrownBy(() -> validateLottoNumbers(List.of(1,2,3,4,5,5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateBonusNumberTest() {
        assertThatThrownBy(() -> validateBonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateInputtedMoneyisNotZeroTest() {
        assertThatThrownBy(() -> validateMoney(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateInputtedMoneyCanDevided1000Test() {
        assertThatThrownBy(() -> validateMoney(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }
}