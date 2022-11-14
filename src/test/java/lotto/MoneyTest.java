package lotto;



import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @DisplayName("구매 금액이 음수일 때 예외를 반환합니다.")
    @Test
    void createMoneyWithNegative(){
        Assertions.assertThatThrownBy(()->new Money(Long.valueOf(-1000)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}