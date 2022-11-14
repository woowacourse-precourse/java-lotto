package util;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

import constant.ErrorMessage;
import java.util.stream.IntStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.OutputView;

class ValidateUserMoneyTest {

    @Test
    @DisplayName("(예외)돈이 1000원 단위로 나눠 떨어지는지 확인! 아닐 경우")
    void checkProcessIsCorrectMoney() {
        int money = 1234;
        int CURRENCY_UNIT = 1000;
        String message = null;
        try {
            if (money % CURRENCY_UNIT > 0) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_INCORRECT_CURRENCY.getMessage());
            }
        } catch (IllegalArgumentException e) {
            message = e.getMessage();
            OutputView.printException(e);
        }

        Assertions.assertThat(message).contains("[ERROR]");
    }

    @Test
    @DisplayName("(예외)사용자 금액이 0원이라면?")
    void checkIsNoMoney(){
        int money=0;
        String message=null;
        try {
            if (money==0) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_NO_MONEY.getMessage());
            }
        } catch (IllegalArgumentException e) {
            message = e.getMessage();
            OutputView.printException(e);
        }

        Assertions.assertThat(message).contains("[ERROR]");

    }


    @Test
    @DisplayName("(예외)사용자 입력이 숫자인지 확인")
    void checkProcessIsNumber() {
        String input_money = "1000j";
        String message = null;
        try {
            IntStream chars = input_money.chars();
            if (chars.anyMatch(c -> (c < '0' || c > '9'))) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_INCORRECT_MONEY.getMessage());
            }
        } catch (IllegalArgumentException e) {
            message = e.getMessage();
            OutputView.printException(e);
        }
        Assertions.assertThat(message).contains("[ERROR]");

    }


}