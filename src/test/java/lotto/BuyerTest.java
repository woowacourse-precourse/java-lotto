package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BuyerTest {
    private Buyer buyer;
    @BeforeEach
    void initBuyer(){
        buyer=new Buyer();
    }
    @DisplayName("1000으로 나누어 떨어지지 않는 경우.")
    @ParameterizedTest
    void purchaseMoneyNotDividedBy1000(int money){
        assertThatThrownBy(() -> buyer.buy(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다.");
    }

}