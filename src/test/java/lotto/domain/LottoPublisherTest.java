package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LottoPublisherTest {

    private Buyer buyer;

    @BeforeEach
    void init() {
        buyer = Mockito.mock(Buyer.class);
    }

    @DisplayName("로또 발급 정상 이상 없을 시 테스트")
    @Test
    void publishLotto() {
        when(buyer.getMoney()).thenReturn(8000L);

        assertThat(LottoPublisher.publishLotto(buyer)).isNotEmpty();
    }

    @DisplayName("구매자가 입력한 금액이 1000원 단위가 아닐 시 예외 처리 테스트")
    @Test
    void publishLottoByAmountUnitError() {
        when(buyer.getMoney()).thenReturn(900L);

        assertThatThrownBy(() -> LottoPublisher.publishLotto(buyer))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
