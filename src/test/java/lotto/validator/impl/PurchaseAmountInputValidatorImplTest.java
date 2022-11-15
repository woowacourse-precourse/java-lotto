package lotto.validator.impl;

import lotto.type.ErrorCode;
import lotto.validator.integrated.PurchaseAmountInputValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PurchaseAmountInputValidatorImplTest {

    private final PurchaseAmountInputValidator validator = new PurchaseAmountInputValidatorImpl();

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
        String wrongTarget1 = "0";
        String wrongTarget2 = "9223372036854775808";

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
    public void isDividedByThousandFailure() {
        //given
        String wrongTarget1 = "1001";
        String wrongTarget2 = "999";

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
        Assertions.assertThat(exception1.getMessage()).isEqualTo(ErrorCode.COULD_NOT_DIVIDE_BY_SMALLEST_UNIT.getMessage());
        Assertions.assertThat(exception2.getMessage()).isEqualTo(ErrorCode.COULD_NOT_DIVIDE_BY_SMALLEST_UNIT.getMessage());
    }

    @Test
    public void validateSuccess() {
        //given
        String rightTarget1 = "1000";
        String rightTarget2 = "9223372036854775000";

        //when
        validator.validate(rightTarget1);
        validator.validate(rightTarget2);

        //then
    }
}