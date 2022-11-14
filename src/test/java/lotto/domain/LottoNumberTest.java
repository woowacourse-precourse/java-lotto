package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {

    @DisplayName("equals 메소드 확인")
    @Test
    void equals() {
        assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber(1));
    }
}