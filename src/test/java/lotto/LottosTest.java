package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    @DisplayName("구입 금액에 맞게 로또가 생성되었는지 개수 확인")
    void testLottoListSize() {
        int amount = 10_000;
        Lottos lottos = new Lottos(amount);
        assertThat(lottos.getLottos())
                .size()
                .isEqualTo(10);
    }

    @Test
    @DisplayName("구입 금액이 0원인 경우")
    void testZeroAmount() {
        int amount = 0;
        Lottos lottos = new Lottos(amount);
        assertThat(lottos.getLottos())
                .isNotNull()
                .isEmpty();
    }

    @Test
    @DisplayName("로또 리스트룰 수정하려 할 경우 예외 발생")
    void throwExceptionWhenTryToChangeTicket() {
        int amount = 10_000;
        Lottos lottos = new Lottos(amount);
        assertThatThrownBy(() -> lottos.getLottos().clear())
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
