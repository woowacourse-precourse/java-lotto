package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class BonusTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("보너스 번호가 숫자로 변환할 수 없는 입력값이면 예외가 발생한다.")
    @Test
    void createBonusByIsNumbers() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    runException("1000", "1,2,3,4,5,6", "a");
                    assertThat(output()).contains(ERROR_MESSAGE);
                },
                List.of(8, 21, 23, 41, 42, 44)
        );
    }

    @DisplayName("보너스 번호가 범위에 벗어난 입력값이면 예외가 발생한다.")
    @Test
    void createBonusByOutOfRange() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    runException("1000", "1,2,3,4,5,6", "46");
                    assertThat(output()).contains(ERROR_MESSAGE);
                },
                List.of(8, 21, 23, 41, 42, 44)
        );
    }

    @DisplayName("보너스 번호가 당첨번호에 중복된 입력값이면 예외가 발생한다.")
    @Test
    void createBonusByDuplicateNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    runException("1000", "1,2,3,4,5,6", "6");
                    assertThat(output()).contains(ERROR_MESSAGE);
                },
                List.of(8, 21, 23, 41, 42, 44)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
