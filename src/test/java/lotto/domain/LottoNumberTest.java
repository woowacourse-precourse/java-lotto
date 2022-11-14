package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @DisplayName("로또 번호가 허용 범위를 벗어나는 경우 에러가 발생하는지 확인한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, 46, 100})
    void checkNumberBoundary(int number) {
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호의 허용 범위를 벗어난 숫자입니다.");
    }
}
