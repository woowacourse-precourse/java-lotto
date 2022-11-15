package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseMoneyTest {

    @DisplayName("사용자는 1000의 배수를 입력해야합니다.")
    @Test
    void createPurchaseMoneyItSNotMultipleThousand(){
        assertThatThrownBy(() -> new PurchaseMoney(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 금액을 입력하면 해당 금액을 1000으로 나눈 개수를 출력합니다.")
    @Test
    void getNumberLotteryPurchasesAvailable() {
        Assertions.assertThat(new PurchaseMoney(5000).getNumberLotteryPurchasesAvailable())
                .isEqualTo(5);
    }
}