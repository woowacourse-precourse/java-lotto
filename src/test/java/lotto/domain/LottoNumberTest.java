package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @Test
    @DisplayName("로또 번호에 최대값보다 큰 경우")
    void createLottoNumberByOverValue() {
        assertThatThrownBy(() -> LottoNumber.getInstance(LottoNumber.MAX_VALUE + 1));
    }

    @Test
    @DisplayName("로또 넘버가 최소값보다 작은 경우")
    void createLottoNumberByLowerValue() {
        assertThatThrownBy(() -> LottoNumber.getInstance(LottoNumber.MIN_VALUE - 1));
    }

}