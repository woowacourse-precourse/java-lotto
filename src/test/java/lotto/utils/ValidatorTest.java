package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import lotto.domain.Message.ErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    Validator validator;

    @BeforeEach
    void beforeEach() {
        validator = new Validator();
    }

//    @Test
//    public void 입력한_보너스_번호가_기존_로또_번호에_이미_있는_경우() {
//        //given
//        List<Integer> lottoNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
//        int input = 3;
//        //when
//        Exception exception = assertThrows(IllegalArgumentException.class, () -> validator.isValidBonusNumber(lottoNumbers, input));
//        //then
//        assertThat(exception.getMessage()).isEqualTo(ErrorMessage.LOTTO_NUMBER_IS_DUPLICATED.toString());
//    }
//
//    @Test
//    public void 입력한_보너스_번호가_범위를_벗어난_경우() {
//        //given
//        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
//        int input = 0;
//        //when
//        Exception exception = assertThrows(IllegalArgumentException.class, () -> validator.isValidBonusNumber(lottoNumbers, input));
//        //then
//        assertThat(exception.getMessage()).isEqualTo(ErrorMessage.LOTTO_NUMBER_IS_NOT_VALID_RANGE.toString());
//    }

    @Test
    public void 입력한_금액이_숫자가_아닌_경우() {
        //given
        String input = "1000j";
        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> validator.isValidMoney(input));
        //then
        assertThat(exception.getMessage()).isEqualTo(ErrorMessage.MONEY_IS_NOT_NUMBER.getMessage());
    }

    @Test
    public void 입력한_금액이_0인_경우() {
        //given
        String input = "0";
        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> validator.isValidMoney(input));
        //then
        assertThat(exception.getMessage()).isEqualTo(ErrorMessage.MONEY_IS_ZERO.getMessage());
    }

    @Test
    public void 입력한_금액이_없는_경우() {
        //given
        String input = "";
        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> validator.isValidMoney(input));
        //then
        assertThat(exception.getMessage()).isEqualTo(ErrorMessage.MONEY_IS_NOT_ENTERED.getMessage());
    }

    @Test
    public void 입력한_금액이_1000으로_나누어_떨어지지_않는_경우() {
        //given
        String input = "1010";
        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> validator.isValidMoney(input));
        //then
        assertThat(exception.getMessage()).isEqualTo(ErrorMessage.MONEY_IS_NOT_1000_UNIT.getMessage());
    }
}