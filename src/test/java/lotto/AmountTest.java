package lotto;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AmountTest {
    Amount amount;

    @BeforeEach
    void amountInit() {
        amount = new Amount(14000);
    }

    @Test
    @DisplayName("로또 구입 금액이 1000으로 나누어 떨어지는지 테스트")
    void divideAmountByThousand() {
        assertThat(amount.isValidateAmount()).isTrue();
        amount = new Amount(14500);
        assertThat(amount.isValidateAmount()).isFalse();
    }

    @Test
    void 로또_개수_테스트(){
        assertThat(amount.getLottoCount()).isEqualTo(14);
        assertThat(new Amount(1000).getLottoCount()).isEqualTo(1);
        assertThat(new Amount(0).getLottoCount()).isEqualTo(0);
    }
}
