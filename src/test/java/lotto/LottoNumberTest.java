package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 번호는")
class LottoNumberTest {

    @DisplayName("정상 범위에서 생성된다.")
    @Test
    void createLottoNumberByValidRange() {
        LottoNumber lottoNumber = new LottoNumber(32);
        assertThat(lottoNumber.getNumber()).isEqualTo(32);
    }

    @DisplayName("허용 범위보다 낮은 값이면 예외를 발생한다.")
    @Test
    void createLottoNumberByBelowRange() {
        assertThatThrownBy(()->new LottoNumber(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("허용 범위보다 큰 값이면 예외를 발생한다.")
    @Test
    void createLottoNumberByOverRange() {
        assertThatThrownBy(()->new LottoNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}