package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BuyerTest {
    private Buyer buyer;

    @BeforeEach
    void setUp() {
        buyer = new Buyer();
    }

    @DisplayName("구매자 돈 정수")
    @Test
    void createBuyerMoney() {
        String input = "3000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        buyer.setMoney();
        assertThat(buyer.money).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("구매자 돈이 정수가 아닐경우 예외 처리")
    @Test
    void createMoneyByNotInt() {
        String input = "not int";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> buyer.setMoney())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
