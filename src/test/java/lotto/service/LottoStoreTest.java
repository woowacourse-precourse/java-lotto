package lotto.service;

import lotto.domain.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoStoreTest {

    private LottoStore lottoStore;

    @BeforeEach
    void setUp() {
        lottoStore = new LottoStore();
    }

    @Test
    @DisplayName("8000원을 입력하면 8개의 리스트가 나와야 한다.")
    void createLottos() {
        assertThat(lottoStore.buyLottos(new Money("8000")).size()).isEqualTo(8);
    }

    @Test
    @DisplayName("8080원을 입력하면 예외처리 되어야 한다.")
    void createLottosNotDivide() {
        assertThatThrownBy(() -> lottoStore.buyLottos(new Money("8080"))).isInstanceOf(IllegalArgumentException.class);
    }
}
