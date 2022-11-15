package lotto.domain;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @DisplayName("구입 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void checkBuyMoneyIsNotNumeric() {
        assertThatThrownBy(() -> new Money("100d0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
