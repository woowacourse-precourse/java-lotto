package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class ManagerTest {

    @DisplayName("입력한 금액이 유효하지 않을 때 예외를 발생시키는지 검사한다.")
    @ParameterizedTest
    @ValueSource(strings = {"dd2", "5500"})
    void validateAmountInput(String amountInput) {
        Manager manager = new Manager();
        assertThatThrownBy(() -> manager.validateAmountInput(amountInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매한 로또 개수만큼의 로또를 생성하고 저장하는지 검사한다.")
    @Test
    void setPurchasedLottos() {
        Manager manager = new Manager();
        manager.setPurchasedLottos(8);
        assertThat(manager.getPurchasedLottos().size()).isEqualTo(8);
    }
}
