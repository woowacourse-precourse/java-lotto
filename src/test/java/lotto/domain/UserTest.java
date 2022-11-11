package lotto.domain;

import lotto.exception.LottoError;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserTest {

    @Test
    void 유저_금액_입력_받기() throws Exception {
        //given
        User user = new User();

        //when
        user.inputPurchaseAmount("5000");

        //then
        assertThat(user.getPurchaseAmount()).isEqualTo(5000);
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
                () -> user.inputPurchaseAmount(wrongUnit))
                .getMessage().equals(LottoError.WRONG_UNIT_OF_WON.getErrorMessage());

        assertThrows(IllegalArgumentException.class,
                () -> user.inputPurchaseAmount(notNumeric))
                .getMessage().equals(LottoError.NOT_NUMERIC.getErrorMessage());
    }

    @Test
    void 로또_발행하기() throws Exception {
        //given
        User user = new User();
        user.inputPurchaseAmount("50000");

        //when
        user.createLottos();

        //then
        assertThat(user.getLottos().size()).isEqualTo(50);
        assertThat(user.getLottos().get(0).getNumbers()).isSorted();
    }

    @Test
    void 수익률_계산하기() throws Exception {
        //given
        User user = new User();
        user.inputPurchaseAmount("50000");
        user.getPrizes().addCount(Prize.FIRST);
        user.getPrizes().addCount(Prize.FIRST);

        //when
        String yield = user.getYield();

        //then
        double expectedResult = (long) Prize.FIRST.getPrize() * 2 / user.getPurchaseAmount() * 100;
        assertThat(Double.parseDouble(yield)).isEqualTo(expectedResult);
        System.out.println("yield = " + yield);
    }
}