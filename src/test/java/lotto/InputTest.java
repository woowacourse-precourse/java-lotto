package lotto;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputTest {
    @DisplayName("구입 금액이 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void checkPurchaseMoney() {
        final String ERROR_MESSAGE = "[ERROR]";
        try{
            Input input = new Input();
            String money = "1000j";
            input.inputValidate(money);
        } catch(IllegalArgumentException e){
            e.getMessage().contains(ERROR_MESSAGE);
        }
    }

    @DisplayName("구입 금액이 1000단위가 아닐 경우 예외가 발생한다.")
    @Test
    void checkMoneyDivide() {
        final String ERROR_MESSAGE = "[ERROR]";
        try{
            Input input = new Input();
            String money = "1004";
            input.inputValidate(money);
        } catch(IllegalArgumentException e){
            e.getMessage().contains(ERROR_MESSAGE);
        }
    }
}