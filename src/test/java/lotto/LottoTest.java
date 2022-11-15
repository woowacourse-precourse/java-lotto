package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 이미_존재하는_로또_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("5000");
                    assertThat(output()).contains(ERROR_MESSAGE);
                },
                List.of(14, 3, 16, 33, 42, 45),
                List.of(14, 3, 33, 16, 42, 45),
                List.of(4, 5, 6, 1, 2, 33),
                List.of(1, 2, 5, 7, 33, 4),
                List.of(1, 2, 5, 14, 22, 45)
        );
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능

    @DisplayName("로또 번호에 범위에서 벗어난 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRange() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 55, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 기능_범위_예외_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000");
                    assertThat(output()).contains(ERROR_MESSAGE);
                },
                List.of(8, 21, 23, 41, 42,-1)
        );
    }

    @Test
    void 기능_크기_예외_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000");
                    assertThat(output()).contains(ERROR_MESSAGE);
                },
                List.of(8, 21, 23, 41, 42, 44, 32)
        );
    }

    @DisplayName("당첨 번호가 6개가 아닌경우 예외가 발생한다.")
    @Test
    void createWinningByIsNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    runException("1000","1");
                    assertThat(output()).contains(ERROR_MESSAGE);
                },
                List.of(8, 21, 23, 41, 42, 44)
        );
    }

    @DisplayName("당첨 번호에 숫자로 변환할 수 없는 입력값이 있으면 예외가 발생한다.")
    @Test
    void createWinningByIsNumbers() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    runException("1000","1 2 3 a s d");
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
