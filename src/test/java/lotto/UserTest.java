package lotto;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

    @DisplayName("구입 금액이 음수인 경우")
    @Test
    void validatePriceTestNagativePrice() {
        assertThatThrownBy(() -> new User(-7000))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("구입 금액이 최소 금액보다 적은 금액인 경우1(0원인 경우)")
    @Test
    void validatePriceTestLessThanMinimumPrice1() {
        assertThatThrownBy(() -> new User(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("구입 금액이 최소 금액보다 적은 금액인 경우2")
    @Test
    void validatePriceTestLessThanMinimumPrice2() {
        assertThatThrownBy(() -> new User(500))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("구입 금액이 최소 금액보다 적은 금액인 경우")
    @Test
    void validatePriceTestNotDividedBy1000won() {
        assertThatThrownBy(() -> new User(11500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}