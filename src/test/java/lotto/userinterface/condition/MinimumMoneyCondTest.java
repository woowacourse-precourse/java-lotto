package lotto.userinterface.condition;

import lotto.condition.Condition;
import lotto.condition.MinimumMoneyCond;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumMoneyCondTest {

    private final static Condition condition = MinimumMoneyCond.getInstance();

    @Test
    void 최소_금액_미만() {
        // given
        String money = "999";
        // when
        Boolean result = condition.isSatisfied(money);

        // then
        assertThat(result).isFalse();
    }


    @Test
    void 최소_금액_충족() {
        // given
        String money = "1000";
        // when
        Boolean result = condition.isSatisfied(money);

        // then
        assertThat(result).isTrue();
    }

}