package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @DisplayName("로또 번호가 1~45 이내 숫자가 아니면 예외 발생")
    @Test
    void 범위내_숫자() {
        LottoNumber lottoNumber = new LottoNumber(3);
        assertThat(lottoNumber).isNotNull();
    }

    @Test
    void 범위이전_숫자() {
        assertThatThrownBy(() -> new LottoNumber(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 범위이후_숫자2() {
        assertThatThrownBy(() -> new LottoNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}