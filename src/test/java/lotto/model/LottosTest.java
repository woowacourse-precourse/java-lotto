package lotto.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    @DisplayName("구매금액을 입력받아 로또 리스트 생성 성공")
    void generateLottos_Success() {
        // Given
        int purchaseAmount = 8000;
        int lottoPrice = 1000;

        // When
        Lottos lottos = new Lottos(purchaseAmount);

        // Then
        assertThat(lottos.getLottos().size()).isEqualTo(purchaseAmount/lottoPrice);
    }

    @Test
    @DisplayName("구매금액이 LOTTO_PRICE 단위가 아닌 경우 예외 발생")
    void generateLottos_Exception() {
        // Given
        int purchaseAmount = 15500;
        int lottoPrice = 1000;

        // When // Then
        assertThatThrownBy(() -> new Lottos(purchaseAmount))
            .isInstanceOf(IllegalArgumentException.class);
    }
}