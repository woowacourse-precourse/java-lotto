package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LotteryNumberTest {
    @DisplayName("추첨 번호는 사용자가 구매한 수량만큼 생성되어야 한다.")
    @Test
    void createLotteryNumberByPurchaseQuantity() {
        LotteryNumber lotteryNumber = new LotteryNumber(3000);
        assertThat(lotteryNumber.getNumbers().size() == 3);
    }
}
