package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGeneratorTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -1000, -123123, 123, 100, 1001, 1203123})
    @DisplayName("구입 금액이 1000원으로 나누어 떨어지지 않거나, 0보다 작거나 같은 경우일 때는 실패")
    void lottoGeneratorConstructorTest(int money) {
        assertThatThrownBy(() -> new LottoGenerator(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
