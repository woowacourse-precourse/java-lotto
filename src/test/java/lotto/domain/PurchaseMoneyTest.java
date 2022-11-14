package lotto.domain;

import lotto.domain.PurchaseMoney;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PurchaseMoneyTest {

    @ParameterizedTest(name = "{displayName} {index}")
    @ValueSource(ints = {-1001, -1000, -999, -1, 0, 1, 999, 1001})
    @DisplayName("예외 발생 테스트")
    public void exceptionTest() {
        int purchaseMoney = 0;

        assertThatThrownBy(() -> new PurchaseMoney(purchaseMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매한 로또 개수가 1개인지 테스트")
    public void getLottoCountIsOneTest() {
        PurchaseMoney purchaseMoney = new PurchaseMoney(1000);
        int purChaseLottoCount = purchaseMoney.getLottoCount();

        assertThat(purChaseLottoCount).isEqualTo(1);
    }

    @Test
    @DisplayName("구매한 로또 개수가 2개인지 테스트")
    public void getLottoCountIsTwoTest() {
        PurchaseMoney purchaseMoney = new PurchaseMoney(2000);
        int purChaseLottoCount = purchaseMoney.getLottoCount();

        assertThat(purChaseLottoCount).isEqualTo(2);
    }

    @Test
    @DisplayName("구매한 로또 개수가 3개인지 테스트")
    public void getLottoCountIsThreeTest() {
        PurchaseMoney purchaseMoney = new PurchaseMoney(3000);
        int purChaseLottoCount = purchaseMoney.getLottoCount();

        assertThat(purChaseLottoCount).isEqualTo(3);
    }

    @ParameterizedTest(name = "{displayName} {index}")
    @ValueSource(ints = {10000, 15000, 20000, 25000, 30000})
    @DisplayName("정상 실행 테스트")
    public void normalTest(int input) {
        assertDoesNotThrow(() -> new PurchaseMoney(input));
    }
}
