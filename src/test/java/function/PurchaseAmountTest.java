package function;

import java.io.ByteArrayInputStream;
import lotto.Ui;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseAmountTest {

    @DisplayName("정상적인 입력")
    @Test
    void correctInput() {
        String data = "5000";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        assertThat(Ui.inputPurchaseAmount()).isEqualTo(5000);
    }

    @DisplayName("숫자가 아닌 경우")
    @Test
    void notNumber() {
        String data = "5000a";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        assertThatThrownBy(() -> Ui.inputPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]: 구입금액은 숫자만 입력이 가능합니다.");
    }

    @DisplayName("1000으로 나누어 떨어지지 않는 경우")
    @Test
    void notDivisibleBy1000() {
        String data = "5001";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        assertThatThrownBy(() -> Ui.inputPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]: 구입금액이 1000으로 나누어 떨어지지 않습니다.");
    }
}