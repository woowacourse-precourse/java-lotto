package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.exception.Valid;
import util.message.ErrorMessage;

class PurchaseTest {

    @Test
    @DisplayName("[Purchase-valid]로또구매시 정상적인 값 테스트")
    void purchaseMoney() {
        //given
        String correctPurchaseMoney="7000";
        //when
        boolean result = Purchase.validate(correctPurchaseMoney);
        //then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("[Purchase-valid]구매 금액이 1000단위가아닌경우 예외발생 테스트")
    void MoneyNotThousandUnit() {
        //given
        String purchaseNotUnit="1001";
        //when
        //then
        assertThatThrownBy(() -> Purchase.validate(purchaseNotUnit))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.UNIT_THOUSAND_MONEY);
    }

    @Test
    @DisplayName("[Purchase-valid]구매금액이 1000원 미만인 경우 예외발생 테스트")
    void MoneyUnderThousand() {
        //given
        String purchaseUnderThousand="800";
        //when
        //then
        assertThatThrownBy(() -> Purchase.validate(purchaseUnderThousand))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.OVER_THOUSAND_MONEY);
    }

    @Test
    @DisplayName("[Purchase-valid]구매금액이 1000원 미만인 경우 예외발생 테스트")
    void moneyIsDigit() {
        //given
        String purchaseNotDigit="8000원";
        //when
        //then
        assertThatThrownBy(() -> Purchase.validate(purchaseNotDigit))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.NOT_STRING_MONEY);
    }
}