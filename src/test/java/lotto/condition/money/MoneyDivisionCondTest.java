package lotto.condition.money;

import lotto.condition.Condition;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoneyDivisionCondTest {

    private static final Condition condition = MoneyDivisionCond.getInstance();

    @Test
    void 천원으로_나누어_떨어지지_않는_금액() {
        // given
        String[] moneies = {"1001", "999"};

        // when, then
        for (String money : moneies) {
            assertThat(condition.isSatisfied(money)).isFalse();
        }
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