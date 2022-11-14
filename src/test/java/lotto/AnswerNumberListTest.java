package lotto;


import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class AnswerNumberListTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("당첨번호 목록에 음수가 있을 경우 예외발생")
    public void checkNegativeInWinningNumbers() {
        assertSimpleTest(() -> {
            new AnswerNumberList(List.of(-2L, 3L, 2L, 1L, 4L, 5L), 4L);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("보너스 번호에 음수가 있을 경우 예외발생")
    public void checkNegativeInBonusNumber() {
        assertSimpleTest(() -> {
            new AnswerNumberList(List.of(6L, 3L, 2L, 1L, 4L, 5L), -4L);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("보너스 번호에 범위밖 수가 있을 경우 예외 발생")
    public void checkRangeInBonusNumber() {
        assertSimpleTest(() -> {
            new AnswerNumberList(List.of(6L, 3L, 2L, 1L, 4L, 5L), 47L);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("당첨 번호 목록에 범위밖 수가 있을 경우 예외 발생")
    public void checkRangeInWinningNumbers() {
        assertSimpleTest(() -> {
            new AnswerNumberList(List.of(46L, 3L, 2L, 1L, 4L, 5L), 4L);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Override
    protected void runMain() {

    }
}