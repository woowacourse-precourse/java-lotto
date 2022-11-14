package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {

    @DisplayName("equals 메소드 테스트")
    @Test
    void equals() {
        assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber(1));
    }

    @DisplayName("int 형 변환 테스트")
    @Test
    void mapToInt() {
        assertThat(new LottoNumber(1).mapToInt()).isEqualTo(1);
    }
}