package lotto.validator.impl;

import java.util.List;
import lotto.type.ErrorCode;
import lotto.validator.integrated.WinningNumberInputValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WinningNumberValidatorImplTest {

    private final WinningNumberInputValidator validator = new WinningNumberInputValidatorImpl();

    @Test
    public void isNumericFailure() {
        //given
        List<String> wrongTarget = List.of("a", "b");

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
        List<String> wrongTarget1 = List.of("0");
        List<String> wrongTarget2 = List.of("46");

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
    public void isValidSizeFailure() {
        //given
        List<String> wrongTarget = List.of("1");

        //when
        //then
        IllegalArgumentException exception = org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> validator.validate(wrongTarget)
        );
        Assertions.assertThat(exception.getMessage()).isEqualTo(ErrorCode.LOTTO_SIZE_ERROR.getMessage());
    }

    @Test
    public void isDuplicateFailure() {
        //given
        List<String> wrongTarget1 = List.of("1", "1", "1", "1", "1", "1");
        List<String> wrongTarget2 = List.of("1", "2", "3", "4", "5", "5");

        //when
        IllegalArgumentException exception1 = org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> validator.validate(wrongTarget1)
        );
        IllegalArgumentException exception2 = org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> validator.validate(wrongTarget2)
        );
        Assertions.assertThat(exception1.getMessage()).isEqualTo(ErrorCode.DUPLICATE_ERROR.getMessage());
        Assertions.assertThat(exception2.getMessage()).isEqualTo(ErrorCode.DUPLICATE_ERROR.getMessage());
    }

    @Test
    public void validateSuccess() {
        //given
        List<String> rightTarget1 = List.of("1", "2", "3", "4", "5", "6");
        List<String> rightTarget2 = List.of("45", "44", "43", "42", "41", "40");

        //when
        validator.validate(rightTarget1);
        validator.validate(rightTarget2);

        //then
    }
}