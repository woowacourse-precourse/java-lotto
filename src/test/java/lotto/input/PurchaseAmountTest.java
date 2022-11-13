package lotto.input;

import lotto.exception.ScopeOverException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PurchaseAmountTest {
    PurchaseAmount purchaseAmount = new PurchaseAmount();

    @Test
    void putAmountTest() {
        String InputTestCase1 = "3000";
        String InputTestCase2 = "1234";
        System.setIn(new ByteArrayInputStream(InputTestCase1.getBytes()));
        assertThat(purchaseAmount.putAmount()).isEqualTo(Integer.parseInt(InputTestCase1));

        System.setIn(new ByteArrayInputStream(InputTestCase2.getBytes()));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> purchaseAmount.putAmount());
    }//putAmount
}//end class
