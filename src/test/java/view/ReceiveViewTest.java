package view;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import model.Purchase;
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

    @Test
    @DisplayName("[ReceiveView] 당첨번호입력시 1,2,3,4,,,5 와 같이 유효하지 않은 인풋값 테스트")
    void winLottoNotValid(){
        //given
        String winLottoInput = "1,2,3,4,,,5";
        //when
        ;
        //then
        assertThatThrownBy(() -> ReceiveView.winLottoValid(winLottoInput))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.INVALID_INPUT_WIN_LOTTO);
    }

    @Test
    @DisplayName("[ReceiveView] 당첨번호입력시 1,2,3,4,5,6 와 같이 유효하지 않은 인풋값 테스트")
    void winLottoValid(){
        //given
        String winLottoInput = "1,2,3,4,5,6";
        //when
        //then
        assertDoesNotThrow(()-> ReceiveView.winLottoValid(winLottoInput));
    }
}