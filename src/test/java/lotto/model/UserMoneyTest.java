package lotto.model;

import lotto.domain.model.UserMoney;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserMoneyTest {
    @DisplayName("구입 금액이 1000단위가 아닐 경우 예외가 발생한다.")
    @Test
    void 구입_금액_1000단위_아닌_경우_예외_테스트() {
        assertThatThrownBy(() -> new UserMoney(1004))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
