package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

    @DisplayName("로또를 수량만큼 추가")
    @Test
    void add_lotto() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        lottoNumbers.addLotto(5);
        assertThat(lottoNumbers.getLottoQuantity()).isEqualTo(5);

        lottoNumbers.addLotto(3);
        assertThat(lottoNumbers.getLottoQuantity()).isEqualTo(8);
    }
}
