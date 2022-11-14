package lotto.domain;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoNumberTest {

    @ParameterizedTest(name = "{displayName} {index}")
    @ValueSource(ints = {-1, 0, 46})
    @DisplayName("예외 발생 테스트")
    public void exceptionTest() {
        int lottoNumber = 0;

        assertThatThrownBy(() -> new LottoNumber(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{displayName} {index}")
    @ValueSource(ints = {1, 25, 45})
    @DisplayName("정상 실행 테스트")
    public void normalTest(int number) {
        assertDoesNotThrow(() -> new LottoNumber(number));
    }
}
