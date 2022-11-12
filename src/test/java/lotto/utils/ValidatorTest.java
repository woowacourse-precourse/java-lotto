package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import lotto.domain.ErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    Validator validator;

    @BeforeEach
    void beforeEach() {
        validator = new Validator();
    }

    @Test
    public void 입력한_금액이_숫자가_아닌_경우() {
        //given
        String input = "-134";
        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> validator.isValidMoney(input));
        //then
        assertThat(exception.getMessage()).isEqualTo(ErrorMessage.MONEY_IS_NOT_NUMBER.toString());
    }

    @Test
    public void 입력한_금액이_0인_경우() {
        //given
        String input = "0";
        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> validator.isValidMoney(input));
        //then
        assertThat(exception.getMessage()).isEqualTo(ErrorMessage.MONEY_IS_ZERO.toString());
    }

    @Test
    public void 입력한_금액이_없는_경우() {
        //given
        String input = "";
        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> validator.isValidMoney(input));
        //then
        assertThat(exception.getMessage()).isEqualTo(ErrorMessage.MONEY_IS_NOT_ENTERED.toString());
    }

    @Test
    public void 입력한_금액이_1000으로_나누어_떨어지지_않는_경우() {
        //given
        String input = "1010";
        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> validator.isValidMoney(input));
        //then
        assertThat(exception.getMessage()).isEqualTo(ErrorMessage.MONEY_IS_NOT_1000_UNIT.toString());
    }
}