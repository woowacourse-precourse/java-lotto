package lotto;

import lotto.Data.UserMoney;
import lotto.handler.InputMoneyHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputMoneyTest {
    InputMoneyHandler inputMoneyHandler = new InputMoneyHandler();

    @DisplayName("사용자의 입력 금액이 User에 저장 되었는지 확인 Test")
    @Test
    void checkUserInputMoney() {
        String inputMoney = "1000";
        UserMoney userMoney = new UserMoney(Integer.parseInt(inputMoney));

        assertThat(Integer.parseInt(inputMoney)).isEqualTo(userMoney.getMoney());
    }

    @DisplayName("사용자의 금액 입력시 아무런 값이 입력되지 않았을때 예외 발생하는지 확인 Test")
    @Test
    void checkExistReadLint() {
        String inputMoney = "";

        assertThatThrownBy(() -> {
            inputMoneyHandler.checkExist(inputMoney);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자의 입력 금액이 숫자가 아닐 때 예외발생 Test")
    @Test
    void checkIsNumber() {
        String inputMoney = "1000a";

        assertThatThrownBy(() -> {
            inputMoneyHandler.checkIsNumber(inputMoney);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자의 입력 금액이 0일 때 예외발생 Test")
    @Test
    void checkIsNonzero() {
        String inputMoney = "0";

        assertThatThrownBy(() -> {
            inputMoneyHandler.checkPositiveNumber(inputMoney);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자의 입력 금액이 0 이하일 때 예외발생 Test")
    @Test
    void checkMinusNumber() {
        String inputMoney = "-4";

        assertThatThrownBy(() -> {
            inputMoneyHandler.checkPositiveNumber(inputMoney);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자의 입력 금액이 1000으로 나누어지지 않을 때 예외발생 Test")
    @Test
    void checkIsValidMoney() {
        String inputMoney = "1001";

        assertThatThrownBy(() -> {
            inputMoneyHandler.checkIsValidMoney(inputMoney);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}