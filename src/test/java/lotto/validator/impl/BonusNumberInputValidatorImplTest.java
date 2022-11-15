package lotto.validator.impl;

import lotto.type.ErrorCode;
import lotto.type.LottoInformation;
import lotto.validator.integrated.BonusNumberInputValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BonusNumberInputValidatorImplTest {

    private final BonusNumberInputValidator validator = new BonusNumberInputValidatorImpl();

    @Test
    public void isNumericFailure() {
        //given
        String wrongTarget = "wrong";

        //when
        //then
        IllegalArgumentException exception = org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> validator.validate(wrongTarget)
        );
        Assertions.assertThat(exception.getMessage()).isEqualTo(ErrorCode.NON_NUMERIC_VALUE.getMessage());
    }

    @Test
    public void isInRangeFailure() {
        //given
        String wrongTarget1 = String.valueOf(LottoInformation.START.value() - 1);
        String wrongTarget2 = String.valueOf(LottoInformation.END.value() + 1);

        //when
        //then
        IllegalArgumentException exception1 = org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> validator.validate(wrongTarget1)
        );
        IllegalArgumentException exception2 = org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> validator.validate(wrongTarget2)
        );
        Assertions.assertThat(exception1.getMessage()).isEqualTo(ErrorCode.TOO_BIG_OR_TOO_SMALL_VALUE.getMessage());
        Assertions.assertThat(exception2.getMessage()).isEqualTo(ErrorCode.TOO_BIG_OR_TOO_SMALL_VALUE.getMessage());
    }

    @Test
    public void validateSuccess() {
        //given
        String rightTarget1 = String.valueOf(LottoInformation.START.value());
        String rightTarget2 = String.valueOf(LottoInformation.END.value());

        //when
        validator.validate(rightTarget1);
        validator.validate(rightTarget2);
        //then
    }
}