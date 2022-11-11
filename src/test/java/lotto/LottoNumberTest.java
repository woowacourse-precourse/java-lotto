package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @ParameterizedTest(name = "범위 1~45 밖의 로또 번호 {0}은 IllegalArgument 예외를 발생시킨다")
    @ValueSource(ints = {0, 46})
    void number_out_of_range_1_to_45_throws_IllegalArgumentException(Integer number) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(number));
    }

    @DisplayName("로또 번호가 같은지 비교할 수 있다")
    @Test
    void decide_lotto_number_equals() {
        assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber(1));
        assertThat(new LottoNumber(2)).isNotEqualTo(new LottoNumber(1));
    }
}
