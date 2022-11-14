package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    @DisplayName("Lotto 리스트, 구매 금액을 사용하여 Lottos 객체 생성 성공")
    void createLottos_Success() {
        // Given
        String purchaseAmountStr = "8000";
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));

        // When
        Lottos lottos = new Lottos(List.of(lotto1, lotto2), purchaseAmountStr);

        // Then
        assertThat(lottos.getLottos().size()).isEqualTo(2);
    }

}