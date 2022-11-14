package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {
    @DisplayName("구입 금액이 1000원 단위가 아니라면 예외를 반환한다.")
    @Test
    void validateTest_1000원단위가_아닌경우() {
        Assertions.assertThatThrownBy(
                        () -> new User(12314)
                )
                .isInstanceOf(IllegalArgumentException.class);
    }
}
