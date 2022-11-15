package lotto;

import lotto.domain.LottoStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStoreTest {
    @DisplayName("로또 개수만큼 숫자 배열 생성")
    @Test
    void createNumbersAsLottoCounts() {
        assertThat(LottoStore.saleLotto(3).size())
                .isEqualTo(3);
    }
}
