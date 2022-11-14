package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ManagerTest {

    @DisplayName("1000원 이하가 입력될 떄")
    @Test
    void priceUnder1000() throws Exception {
        //Given
        Manager manager = new Manager();

        //When
        assertThatThrownBy(()->manager.getPurchasePrice(950))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원으로 안 나눠 떨어질 때")
    @Test
    void priceDoesNotDivided1000() throws Exception {
        //Given
        Manager manager = new Manager();

        //When
        assertThatThrownBy(()->manager.getPurchasePrice(21312))
                .isInstanceOf(IllegalArgumentException.class);
    }

}