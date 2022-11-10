package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AmountTest {

    private Amount amount;

    @DisplayName("1000원으로 나누어 떨어지지 않으면 예외가 발생한다")
    @Test
    void inputNumberDividedBy1000RemainingNumber() {
        amount = new Amount(12344);

        assertThatThrownBy(() -> amount.getPurchasesQuantity())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("만 원 입력 시 10개를 반환한다")
    @Test
    void returnPurchasesNumber() {
        amount = new Amount(10000);

        assertThat(amount.getPurchasesQuantity()).isEqualTo(10);
    }
}
