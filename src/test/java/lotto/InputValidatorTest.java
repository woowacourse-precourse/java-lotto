package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {
    InputValidator inputValidator = new InputValidator();
    @Test
    @DisplayName("구매 비용입력시 숫자가 아닐 때")
    void purchaseNotNumber() throws Exception {
        //given
        String input = "1000kk";
        //when
        //then
        assertThatThrownBy(() -> inputValidator.validateInputPurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매비용 입력시 천 단위가 아니면 예외처리")
    void purchaseNotThousand() throws Exception {
        //given
        String input = "100080";
        //when
        //then
        assertThatThrownBy(() -> inputValidator.validateInputPurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨번호 포멧이 맞지 않을 때")
    void winningNumberNotSuitFormat() throws Exception {
        //given
        String input = "11,22,33,44";
        //when
        //then
        assertThatThrownBy(() -> inputValidator.validateInputPurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 숫자가 아닐 때")
    void bonusNotNumber() throws Exception {
        //given
        String input = "j";
        Lotto winningNumber = new Lotto(List.of(1,2,3,4,5,6));
        //when
        //then
        assertThatThrownBy(() -> inputValidator.validateInputBonusNumber(input, winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 범위를 초과하였을 때")
    void bonusOutOfRange() throws Exception {
        //given
        String input = "47";
        Lotto winningNumber = new Lotto(List.of(1,2,3,4,5,6));
        //when
        //then
        assertThatThrownBy(() -> inputValidator.validateInputBonusNumber(input, winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 이미 당첨번호에 포함되어 있을 때")
    void bonusIsExistWinningNumber() throws Exception {
        //given
        String input = "3";
        Lotto winningNumber = new Lotto(List.of(1,2,3,4,5,6));
        //when
        //then
        assertThatThrownBy(() -> inputValidator.validateInputBonusNumber(input, winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

}