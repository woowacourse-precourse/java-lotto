package lotto.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseMoneyTest {

    @ParameterizedTest(name = "{displayName} {index}")
    @ValueSource(ints = {-1001, -1000, -999, -1, 0, 1, 999, 1001})
    @DisplayName("예외 발생 테스트")
    public void exceptionTest() {
        int purchaseMoney = 0;

        assertThatThrownBy(() -> new PurchaseMoney(purchaseMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
