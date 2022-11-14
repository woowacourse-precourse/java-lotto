package lotto.domainTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.PurchaseAmount;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PurchaseAmountTest {

    @ParameterizedTest
    @DisplayName("잘못된 금액을 입력받았을 때 예외가 발생하는지 확인")
    @ValueSource(ints = {0, 100, -1})
    public void checkInValidateAmount(int purchaseAmount){
        assertThatThrownBy(() -> new PurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
