package exception;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.exception.Valid;

class ValidTest {

    @Test
    @DisplayName("[Valid]로또구매시 잘못된 값 입력에 대한 예외발생 테스트")
    void purchaseMoney() {
        //given
        int moneyNotUnits=1023;
        int moneyUnderThousand=900;
        //when
        //then
        assertThatThrownBy(() -> Valid.purchaseMoney(moneyNotUnits))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Valid.purchaseMoney(moneyUnderThousand))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("[Valid]구매 금액이 1000단위가아닌경우 false")
    void MoneyNotThousandUnit() {
        //given
        int money=1001;
        //when
        boolean result = Valid.isMoneyThousandUnit(money);
        //then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("[Valid]구매 금액이 1000단위가 맞는경우 true")
    void MoneyThousandUnit() {
        //given
        int money=10000;
        //when
        boolean result = Valid.isMoneyThousandUnit(money);
        //then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("[Valid]구매금액이 1000원 미만인 경우 false 리턴")
    void MoneyUnderThousand() {
        //given
        int money = 823;
        //when
        boolean result = Valid.isMoneyOverThousand(money);
        //then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("[Valid]구매금액이 1000원 이상인경우 true 리턴")
    void MoneyOverThousand() {
        //given
        int money = 1000;
        //when
        boolean result = Valid.isMoneyOverThousand(money);
        //then
        assertThat(result).isTrue();
    }
}