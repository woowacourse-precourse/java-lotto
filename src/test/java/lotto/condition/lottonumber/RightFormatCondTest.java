package lotto.condition.lottonumber;

import lotto.condition.Condition;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RightFormatCondTest {

    private final static Condition condition = RightFormatCond.getInstance();

    @Test
    void 올바른_형식의_입력() {
        // given
        String numbers = "1,2,3,4,5,6";

        // when
        Boolean result = condition.isSatisfied(numbers);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void 잘못된_형식의_입력() {
        // given
        String[] wrongNumbers = {
                "1,2,3,4,5,",
                "1,2,,,,",
                "",
        };
        // when, then
        for (String wrongNumber : wrongNumbers) {
            assertThat(condition.isSatisfied(wrongNumber)).isFalse();
        }
    }
}