package lotto.condition.lottonumber;

import lotto.condition.Condition;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NoDuplicateNumberCondTest {

    private static final Condition condition = NoDuplicateNumberCond.getInstance();

    @Test
    void 전부_다른_숫자() {
        // given
        String numbers = "1,2,3,4,5,6";

        // when
        Boolean result = condition.isSatisfied(numbers);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void 중복_숫자() {
        // given
        String numbers = "1,1,3,4,5,6";

        // when
        Boolean result = condition.isSatisfied(numbers);

        // then
        assertThat(result).isFalse();
    }
}