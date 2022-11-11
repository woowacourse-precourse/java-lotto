package lotto.domain;

import lotto.exception.Input;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class UserTest {

    @Test
    void 유저_금액_입력_받기() throws Exception {
        //given
        User user = new User();

        //when
        user.inputPurchaseAmouont("5000");

        //then
        Assertions.assertThat(user.getPurchaseAmount()).isEqualTo(5000);
    }

    @Test
    void 잘못된_금액_입력() throws Exception {
        //given
        User user = new User();

        //when
        String wrongUnit = "5100";
        String notNumeric = " 123123 ";

        //then
        assertThrows(IllegalArgumentException.class,
                () -> user.inputPurchaseAmouont(wrongUnit))
                .getMessage().equals(Input.WRONG_UNIT_OF_WON.getErrorMessage());

        assertThrows(IllegalArgumentException.class,
                () -> user.inputPurchaseAmouont(notNumeric))
                .getMessage().equals(Input.NOT_NUMERIC.getErrorMessage());
    }
}