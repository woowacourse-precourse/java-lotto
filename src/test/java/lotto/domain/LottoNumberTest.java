package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    private LottoNumber lottoNumber;

    @BeforeEach
    void setUp() {
        lottoNumber = new LottoNumber(1);
    }

    @DisplayName("로또 번호 중 0이 있으면 예외 발생")
    @Test
    void validateMinimumRange() {
        assertThatThrownBy(() -> new LottoNumber(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1~45 사이의 숫자 이어야 합니다.");
    }

    @DisplayName("로또 번호 중 46이 있으면 예외 발생")
    @Test
    void validateMaximumRange() {
        assertThatThrownBy(() -> new LottoNumber(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1~45 사이의 숫자 이어야 합니다.");
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