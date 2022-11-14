package lotto.condition.money;

import lotto.condition.Condition;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoneyDivisionCondTest {

    private static final Condition condition = MoneyDivisionCond.getInstance();

    @Test
    void 천원으로_나누어_떨어지지_않는_금액() {
        // given
        String money = "1001";

        // when
        Boolean result = condition.isSatisfied(money);

        // then
        assertThat(result).isFalse();
    }

    @Test
    void 천원으로_나누어_떨어지는_금액() {
        // given
        String money = "3000";

        // when
        Boolean result = condition.isSatisfied(money);

        assertThat(result).isTrue();
    }

}