package function;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.NoSuchElementException;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest extends NsTest {

    @DisplayName("정상적인 입력")
    @Test
    void correctInput() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]"
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @DisplayName("1개의 숫자가 아닌 경우")
    @Test
    void isNotSingeNumber() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "1,2");
            assertThat(output()).contains("[ERROR]: 보너스 번호는 1개의 숫자만 입력 가능합니다.");
        });
    }

    @DisplayName("숫자가 아닌 경우")
    @Test
    void isNotNumber() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "b");
            assertThat(output()).contains("[ERROR]: 보너스 번호는 1개의 숫자만 입력 가능합니다.");
        });
    }

    @DisplayName("숫자의 범위가 1 ~ 45까지가 아님")
    @Test
    void isNotRangeFrom1To45() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "66");
            assertThat(output()).contains("[ERROR]: 숫자의 범위는 1 ~ 45까지여야 합니다.");
        });
    }

    @DisplayName("당첨 번호들 중 중복값이 존재")
    @Test
    void duplicateNumberInPurchaseAmount() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "6");
            assertThat(output()).contains("[ERROR]: 보너스 번호는 당첨 번호와 중복되면 안됩니다.");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
