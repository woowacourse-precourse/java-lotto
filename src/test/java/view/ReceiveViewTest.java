package view;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.message.ErrorMessage;

class ReceiveViewTest {

    @Test
    @DisplayName("[ReceiveView-purchaseLottoValid] 로또 구매시 구매 input이 숫자가 맞는지 확인한다.")
    void purchaseLottoValid() {
        //given
        String invalidMoney = "1000원";
        //when
        //then
        assertThatThrownBy(() -> ReceiveView.purchaseLottoValid(invalidMoney))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.NOT_STRING_MONEY);
    }
}