package lotto.userinterface.condition;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MoneyDivisionCondTest {

    @Test
    void 천원으로_나누어_떨어지지_않는_금액() {
        // given
        String money = "1001";
        Condition condition = MoneyDivisionCond.getInstance();

        // when
        Boolean result = condition.isSatisfied(money);

        // then
        assertThat(result).isFalse();
    }

    @Test
    void 천원으로_나누어_떨어지는_금액() {
        // given
        String money = "3000";
        Condition condition = MoneyDivisionCond.getInstance();

        // when
        Boolean result = condition.isSatisfied(money);

        assertThat(result).isTrue();
    }

}