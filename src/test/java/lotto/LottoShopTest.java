package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoShopTest {
    @DisplayName("구매 가격이 1000원으로 나눠 떨어지지 않으면 예외가 발생한다.")
    @Test
    void lottoPriceNotDivide() {
        assertThatThrownBy(() -> new LottoShop(14300))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원으로 나눠 떨어지는 가격이 주어졌을때 올바른 값 출력")
    @Test
    void lottoPriceRightDivide() {
        LottoShop testLottoMoney = new LottoShop(14000);
        assertThat(testLottoMoney.LottoCountCalculate()).isEqualTo(14);
    }

}
