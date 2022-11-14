package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class WinningNumbersTest extends NsTest {
    @DisplayName("입력된 로또 번호와 보너스 번호 출력")
    @Test
    void function_test() {
        assertThatCode(
                () -> {
                    run("1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "[1, 2, 3, 4, 5, 6]",
                            "7"
                    );
                }
        );
    }

    @DisplayName("로또 번호에 숫자가 아닌 수가 있으면 예외")
    @Test
    void createException1() {
        assertThatThrownBy(
                () -> {
                    run("1a,2,3,4,5,6", "7");
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 숫자가 아닌 수가 있으면 예외")
    @Test
    void createException2() {
        assertThatThrownBy(
                () -> {
                    run("1,2,3,4,5,6", "7a");
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1개가 아니면 예외")
    @Test
    void createException3() {
        assertThatThrownBy(
                () -> {
                    run("1,2,3,4,5,6", "7,9");
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 로또 번호에 있는 숫자이면 예외")
    @Test
    void createException4() {
        assertThatThrownBy(
                () -> {
                    run("1,2,3,4,5,6", "3");
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {
        new WinningNumbers();
    }
}