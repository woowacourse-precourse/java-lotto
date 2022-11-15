package lotto;

import lotto.domain.Buyer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BuyerTest {
    private Buyer buyer;


    @Test
    void createWrongBonus() {
        assertThatThrownBy(() -> Buyer.validatePrice(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1000원 ");
    }

    @Test
    void createBonuswithChar() {
        assertThatThrownBy(() -> Buyer.getIntPrice("150a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 ");
    }
}
