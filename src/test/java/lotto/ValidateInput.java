package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ValidateInput {
    @DisplayName("1000원 단위인지 확인한다.")
    @Test
    void checkMoneyInput(){
        String number = "1500";
        int input = Integer.parseInt(number);
        Validator validateInputMoney = new Validator(number);

        assertThatThrownBy(() -> validateInputMoney.validateInputMoney(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("인당 로또 구매 제한인 10만원 한도를 넘기는지 확인한다. .")
    @Test
    void checkInputNumbers(){
        String number = "150000";
        int check = Integer.parseInt(number);
        Validator validateMaxInputMoney = new Validator(number);

        assertThatThrownBy(() -> validateMaxInputMoney.validateMaxInputMoney(check))
                .isInstanceOf(IllegalArgumentException.class);    }
}
