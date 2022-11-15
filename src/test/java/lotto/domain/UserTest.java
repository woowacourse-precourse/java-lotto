package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class UserTest {
    User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @DisplayName("구입 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void inputPriceByNumber() {
        assertThatThrownBy(() -> user.validate("a1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void inputPriceByUnderThousand() {
        assertThatThrownBy(() -> user.validate("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void inputPriceByDividedThousand() {
        assertThatThrownBy(() -> user.validate("5500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액에 해당하는 로또의 개수를 구했는지 테스트")
    @Test
    void findLottoCountByMoney() {
        int money = 8000;
        int lottoCount = user.setCount(money);
        assertThat(lottoCount).isEqualTo(8);
    }
}