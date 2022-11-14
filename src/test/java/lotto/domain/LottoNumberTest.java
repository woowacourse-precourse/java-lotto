package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {

    private LottoNumber lottoNumber;

    @BeforeEach
    void setUp() {
        lottoNumber = new LottoNumber(1);
    }

    @DisplayName("equals 메소드 테스트")
    @Test
    void equals() {
        assertThat(lottoNumber).isEqualTo(new LottoNumber(1));
    }

    @DisplayName("int 형 변환 테스트")
    @Test
    void mapToInt() {
        assertThat(lottoNumber.mapToInt()).isEqualTo(1);
    }

    @DisplayName("compareTo 메소드 테스트")
    @Test
    void compareTo() {
        assertThat(lottoNumber.compareTo(new LottoNumber(2))).isEqualTo(-1);
    }
}