package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @Test
    @DisplayName("구매금액에 맞게 lotto 리스트를 생성 성공")
    void generateLottos_Success() {
        // Given
        String purchaseAmount = "8000";

        // When
        List<Lotto> lottos = LottoMachine.generateLottos(purchaseAmount);

        // Then
        assertThat(lottos.size()).isEqualTo(8);

    }

    @Test
    @DisplayName("구매금액이 LOTTO_PRICE 단위가 아닌 경우 예외 발생")
    void generateLottos_Exception1() {
        // Given
        String purchaseAmount = "15500";

        // When // Then
        assertThatThrownBy(() -> LottoMachine.generateLottos(purchaseAmount))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매금액 숫자가 아닌 경우 예외 발생")
    void generateLottos_Exception2() {
        // Given
        String purchaseAmount = "8000j";

        // When // Then
        assertThatThrownBy(() -> LottoMachine.generateLottos(purchaseAmount))
            .isInstanceOf(IllegalArgumentException.class);
    }

}