package lotto;

import lotto.domain.User;
import lotto.exception.LottoError;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @Test
    public void 유저_금액_입력_받기() throws Exception {
        //given
        User user = new User();

        //when
        user.inputPurchaseAmount("4000");

        //then
        assertThat(user.getPurchaseAmount()).isEqualTo(4000);
    }

    @Test
    public void 잘못된_금액_입력() throws Exception {
        //given
        User user = new User();

        //when
        String wrongUnit = "4300";
        String notNumeric = " 12345 ";

        //then
        assertThrows(IllegalArgumentException.class,
                () -> user.inputPurchaseAmount(wrongUnit))
                .getMessage()
                .equals(LottoError.WRONG_UNIT_OF_WON.getErrorMessage());
        assertThrows(IllegalArgumentException.class,
                () -> user.inputPurchaseAmount(notNumeric))
                .getMessage()
                .equals(LottoError.NOT_NUMERIC.getErrorMessage());
    }

    @Test
    public void 로또_발행() throws Exception {
        //given
        User user = new User();
        user.inputPurchaseAmount("50000");

        //when
        user.createLottos();

        //then
        assertThat(user.getLottos().size()).isEqualTo(50);
        assertThat(user.getLottos().get(0).sorted()).isSorted();
    }
}
