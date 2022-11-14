package lotto.calculation;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoPurchaseTest {
    @Test
    void getPurchaseCountTest(){
        int amount = 8000;
        assertThat(LottoPurchase.getPurchaseCount(amount)).isEqualTo(8);
    }// getPurchaseCountTest
}// end class
