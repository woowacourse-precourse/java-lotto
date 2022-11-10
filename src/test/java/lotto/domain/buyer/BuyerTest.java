package lotto.domain.buyer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BuyerTest {
    @DisplayName("제시한 액수가 로또 개당 구매비용으로 나눠지지 않으면 에러 발생")
    @Test
    void givenNotDivisibleMoney_whenValidate_thenThrowError() {
        //given
        int money = 1300;
        //when //then
        assertThatThrownBy(() -> Buyer.of(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("제시한 액수가 음수이면 에러 발생")
    @Test
    void givenNegativeNumber_whenValidate_thenThrowError() {
        //given
        int money = -1000;
        //when //then
        assertThatThrownBy(() -> Buyer.of(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("제시한 액수가 로또 개당 구매비용으로 나눠지면 인스턴스 반환")
    @Test
    void givenDivisibleMoney_whenValidate_thenGiveInstance() {
        //given
        int money = 2000;

        //when
        Buyer buyer = Buyer.of(money);

        //then
        assertThat(buyer).isInstanceOf(Buyer.class);
        assertThat(buyer.getMoney()).isEqualTo(money);
    }
}