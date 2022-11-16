package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.Money;
import lotto.domain.WinningTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트() {
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
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 62.5%입니다."
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

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("구입금액 0 입력시 IllegalArgumentException테스트")
    void 로또구입금액_0으로인해_예외발생_테스트() {
        assertSimpleTest(() -> {
            runException("0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @DisplayName("구입 금액이 1000원으로 나누어 떨어지지 않기 때문에 IllegalArgumentException테스트")
    @ValueSource(strings = {"1005", "20001", "500", "2", "200"})
    void 로또구입금액으로인해_예외발생_테스트(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Money(input));
    }

    @ParameterizedTest
    @DisplayName("구입 금액 입력값이 숫자가 아니기 때문에 IllegalArgumentException테스트")
    @ValueSource(strings = {"10000a", "!avb10", "zxcffs", "5000!", "a", "1000.", ""})
    void 로또구입금액_숫자가아니기때문에_예외발생_테스트(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Money(input));
    }

    @ParameterizedTest
    @DisplayName("구입 금액 입력값이 숫자가 아니기 때문에 IllegalArgumentException테스트")
    @ValueSource(strings = {"01000", "0500", "0300", "050000", "090000"})
    void 로또구입금액_0으로_시작할때_예외발생_테스트(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Money(input));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
