package lotto.study.domain.lotto;

import lotto.domain.ingame.Payment;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PaymentTest {

    @DisplayName("0원 구매")
    @Test
    void 구입금액_테스트1() {
        //given
        int amount = 0;

        //when
        //then
        Assertions.assertThatThrownBy(() -> {
            Payment payment = new Payment(amount);
        }).isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("1000000001원 구매")
    @Test
    void 구입금액_테스트2() {
        //given
        int amount = 1000000001;

        //when
        //then
        Assertions.assertThatThrownBy(() -> {
            Payment payment = new Payment(amount);
        }).isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("정상 구매")
    @Test
    void 구입금액_테스트3() {
        //given
        int amount = 1000000000;

        //when
        Payment payment = new Payment(amount);

        //then
        int actual = payment.getAmount();
        int expected = amount;

        Assertions.assertThat(actual).isEqualTo(expected);

    }



}