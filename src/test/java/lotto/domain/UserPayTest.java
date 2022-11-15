package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserPayTest {
    @DisplayName("숫자가 아닌 값이 들어오면 에러가 난다.")
    @Test
    void createUserPayDigit() {
        assertThatThrownBy(() -> new UserPay("1000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("단위가 1000원이 아니면 에러가 난다.")
    @Test
    void createUserPayUnit() {
        assertThatThrownBy(() -> new UserPay("1800").lottoCount())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
