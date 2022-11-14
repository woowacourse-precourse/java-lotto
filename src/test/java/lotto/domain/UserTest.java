package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {
    @DisplayName("구입 금액이 1,000원 단위가 아니면 예외가 발생한다.")
    @Test
    void inputAmountByInvalidUnit() {
        assertThatThrownBy(() -> new User(100, List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1,000원 단위로 입력해주세요.");
    }
}
