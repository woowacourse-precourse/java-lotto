package lotto.condition.money;

import lotto.condition.Condition;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class IsAllNumberCondTest {

    private static final Condition condition = IsAllNumberCond.getInstance();

    @Test
    void 올바른_금액() {
        // given
        List<String> moneies = List.of(
                "1234",
                "1"
        );

        // when, then
        for (String money : moneies) {
            Boolean result = condition.isSatisfied(money);
            assertThat(result).isTrue();
        }
    }

    @Test
    void 잘못된_금액() {
        List<String> moneies = List.of(
                "1234a",
                "1a"
        );

        // when, then
        for (String money : moneies) {
            Boolean result = condition.isSatisfied(money);
            assertThat(result).isFalse();
        }
    }
}