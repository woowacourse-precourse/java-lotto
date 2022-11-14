package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserLottosTest {

    @DisplayName("유효하지 않은 돈을 입력했을 때,예외 발생한다.")
    @ParameterizedTest
    @ValueSource (ints = {1,1005,1500,2300,5000005})
    void validateMoneyTest(int money) {
        assertThatThrownBy(() -> new UserLottos(money))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void setCount() {
    }

    @Test
    void createLottos() {
    }

    @Test
    void getUserLottos() {
    }

    @Test
    void getLottoCount() {
    }
}
