package lotto.condition.lottonumber;

import lotto.condition.Condition;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class IsAllNumberCondTest {
    private static final Condition condition = IsAllNumberInRangeCond.getInstance();

    @Test
    void 올바른_숫자로_구성() {
        // given
        List<String> numbers = List.of(
                "1,2,3,4,5,6",
                "1,10,20,30,44,45"
        );

        // when, then
        for (String number : numbers) {
            assertThat(condition.isSatisfied(number)).isTrue();
        }
    }

    @Test
    void 잘못된_입력() {
        // given
        List<String> numbers = List.of(
                "1 2 3 4 5 6",
                "0,2,3,4,5,66",
                "-1,2,3,4,5,6",
                "a,b,c,1,2,3"
        );

        // when, then
        for (String number : numbers) {
            assertThat(condition.isSatisfied(number)).isFalse();
        }
    }

}