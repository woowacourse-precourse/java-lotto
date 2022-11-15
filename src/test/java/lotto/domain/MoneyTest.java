package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MoneyTest{
    @Test
    void 돈_사용_테스트() throws Exception {
        //given
        Money money = new Money(10000);

        //when
        money.paid(1000, 3);
        int currentMoney = money.getCurrentMoney();
        int paidMoney = money.getPaidMoney();

        //then
        Assertions.assertThat(List.of(currentMoney, paidMoney))
                .containsExactly(7000, 3000);
    }
    @Test
    void 돈_단위_예외() throws Exception {
        //given

        //when

        //then
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Money(1500));
    }

    @Test
    void 돈_사용_초과_예외() throws Exception {
        //given
        Money money = new Money(10000);

        //when

        //then
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> money.paid(1000, 15));
    }
}
