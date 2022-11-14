package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {
    @DisplayName("구입 금액을 1,000으로 나누었을 때 나머지 값이 존재하면 예외 발생")
    @Test
    void hasRemainder() {
    	assertThatThrownBy(() -> new Money(10_001))
    		.isInstanceOf(IllegalArgumentException.class);
    }
}
