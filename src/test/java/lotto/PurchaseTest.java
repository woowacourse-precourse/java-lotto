package lotto;

import lotto.UI.Purchase;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseTest {
    @Test
    void convertInputToNumber_테스트1() {
        String input = "10a";
        int result = 0;

        assertThat(result).isEqualTo(Purchase.convertInputToNumber(input));
    }
    @Test
    void convertInputToNumber_테스트2() {
        String input = "10060";
        int result = 10060;

        assertThat(result).isEqualTo(Purchase.convertInputToNumber(input));
    }

    @Test
    void validate_테스트1() {
        int money = 0;
        boolean result = false;

        assertThatThrownBy(() -> Purchase.validate(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validate_테스트2() {
        int money = 100030;
        boolean result = false;

        assertThatThrownBy(() -> Purchase.validate(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validate_테스트3() {
        int money = 900;
        boolean result = false;

        assertThatThrownBy(() -> Purchase.validate(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void Purchase_테스트1() {
        String input = "1000";
        int result = 1;

        Purchase test = new Purchase(input);
        assertThat(result).isEqualTo(test.getCount());
    }
    @Test
    void Purchase_테스트2() {
        String input = "5000000";
        int result = 5000;

        Purchase test = new Purchase(input);
        assertThat(result).isEqualTo(test.getCount());
    }
    @Test
    void Purchase_테스트3() {
        String input = "50040";

        assertThatThrownBy(() -> new Purchase(input).getCount())
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void Purchase_테스트4() {
        String input = "5000a";

        assertThatThrownBy(() -> new Purchase(input).getCount())
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void Purchase_테스트5() {
        String input = "-5000";

        assertThatThrownBy(() -> new Purchase(input).getCount())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
