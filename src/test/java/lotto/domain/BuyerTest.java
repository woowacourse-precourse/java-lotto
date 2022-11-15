package lotto.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BuyerTest {
    @DisplayName("구입 금액이 1000원 미만일대 예외가 발생한다.")
    @Test
    void createBuyerMoneyLessThanTousand() {
        assertThatThrownBy(() -> new Buyer(200))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000으로 나누어떨어지지 않을 때 예외가 발생한다.")
    @Test
    void createBuyerMoneyMultipleThousand() {
        assertThatThrownBy(() -> new Buyer(5050))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
