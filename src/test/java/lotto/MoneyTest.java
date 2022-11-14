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

    @DisplayName("구매 금액이 1000으로 나누어 떨어지지 않을 때 예외를 반환합니다.")
    @Test
    void createMoneyWithNotDevidedNumberWithThousand(){
        Assertions.assertThatThrownBy(()->new Money(Long.valueOf(1023)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("생성 테스트")
    @Test
    void createMoney(){
        Assertions.assertThat(new Money(Long.valueOf(2000)))
                .isInstanceOf(Money.class);
    }
}