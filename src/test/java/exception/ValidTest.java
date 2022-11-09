package exception;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.exception.Valid;
import util.message.ErrorMessage;

class ValidTest {

    @Test
    @DisplayName("[Valid]로또구매시 정상적인 값 테스트")
    void purchaseMoney() {
        //given
        String purchaseMoney="7000";
        //when
        boolean result = Valid.purchaseMoney(purchaseMoney);
        //then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("[Valid]구매 금액이 1000단위가아닌경우 예외발생 테스트")
    void MoneyNotThousandUnit() {
        //given
        String moneyNotUnits="1001";
        //when
        //then
        assertThatThrownBy(() -> Valid.purchaseMoney(moneyNotUnits))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.UNIT_THOUSAND_MONEY);
    }

    @Test
    @DisplayName("[Valid]구매금액이 1000원 미만인 경우 예외발생 테스트")
    void MoneyUnderThousand() {
        //given
        String moneyUnderThousand="800";
        //when
        //then
        assertThatThrownBy(() -> Valid.purchaseMoney(moneyUnderThousand))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.OVER_THOUSAND_MONEY);
    }

    @Test
    @DisplayName("[Valid]구매금액이 1000원 미만인 경우 예외발생 테스트")
    void moneyIsDigit() {
        //given
        String moneyNotDigit="8000원";
        //when
        //then
        assertThatThrownBy(() -> Valid.purchaseMoney(moneyNotDigit))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.NOT_STRING_MONEY);
    }


}