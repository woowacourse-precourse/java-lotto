package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class AddApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("로또 구매 금액 입력 예외 - 아무 값도 입력하지 않은 경우")
    @Test
    void purchaseBlankAmount() {
        assertSimpleTest(() -> {
            runException("\n");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 구매 금액 입력 예외 - 띄어쓰기만 있는 경우")
    @Test
    void purchaseBlankAmount2() {
        assertSimpleTest(() -> {
            runException("        ");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 구매 금액 입력 예외 - 1000단위가 아닌 경우")
    @Test
    void purchaseNotThousandUnitAmount() {
        assertSimpleTest(() -> {
            runException("12345");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 구매 금액 입력 예외 - 0을 입력한 경우")
    @Test
    void purchaseZeroAmount() {
        assertSimpleTest(() -> {
            runException("0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호 입력 예외 - 값이 6개가 아닌 경우")
    @Test
    void winningNumberIsNotSix() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5");
            System.out.println(output());
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호 입력 예외 - 숫자가 아닌 경우")
    @Test
    void winningNumberIsNotNumber() {
        assertSimpleTest(() -> {
            runException("8000", "a,b,3,4,5,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호 입력 예외 - 범위 내 숫자가 아닌 경우")
    @Test
    void winningNumberOutOfRange() {
        assertSimpleTest(() -> {
            runException("8000", "47,2,3,4,5,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호 입력 예외 - 중복되는 값이 있는 경우")
    @Test
    void winningNumberDuplicateNumber() {
        assertSimpleTest(() -> {
            runException("8000", "1,1,3,4,5,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호 입력 예외 - 값이 없는 경우")
    @Test
    void bonusNumberBlank() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "\n");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호 입력 예외 - 띄어쓰기만 있는 경우")
    @Test
    void bonusNumberBlank2() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "    ");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호 입력 예외 - 값이 하나가 아닌 경우")
    @Test
    void bonusNumberNotOne() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "1,2");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호 입력 예외 - 1 ~ 45 사이의 값이 아닌 경우")
    @Test
    void bonusNumberOutOfRange() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "46");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호 입력 예외 - 중복되는 값이 있는 아닌 경우")
    @Test
    void bonusNumberDuplicateNumber() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
