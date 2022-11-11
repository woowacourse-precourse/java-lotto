package lotto;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @ParameterizedTest(name = "범위 1~45 밖의 로또 번호 {0}은 IllegalArgument 예외를 발생시킨다")
    @ValueSource(ints = {0, 46})
    void number_out_of_range_1_to_45_throws_IllegalArgumentException(Integer number) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(number));
    }
}
