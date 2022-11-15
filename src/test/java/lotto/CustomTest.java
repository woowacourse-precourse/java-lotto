package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.domain.Preset.ERROR_WINNING_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CustomTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    // 단위테스트 - 로또 구입 금액을 입력받는 기능
    @DisplayName("로또 구입 금액이 1,000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 단위_테스트_1_1() {
        assertSimpleTest(() -> {
            runException("1500");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 구입 금액이 1,000원 미만이면 예외가 발생한다.")
    @Test
    void 단위_테스트_1_2() {
        assertSimpleTest(() -> {
            runException("800");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 구입 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void 단위_테스트_1_3() {
        assertSimpleTest(() -> {
            runException("hi");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    // 단위테스트 - 당첨 번호를 입력받는 기능
    @DisplayName("입력값의 형식이 예시와 다르면 예외가 발생한다.")
    @Test
    void 단위_테스트_2_1() {
        assertThatExceptionOfType(NoSuchElementException.class)
                .isThrownBy(() -> {
                            assertRandomUniqueNumbersInRangeTest(
                                    () -> {
                                        run("3000", "1|2,3,4,5,6");
                                        assertThat(output()).contains(
                                                "8개를 구매했습니다.",
                                                "[8, 21, 23, 41, 42, 43]",
                                                "[3, 5, 11, 16, 32, 38]",
                                                "[7, 11, 16, 35, 36, 44]"
                                        );
                                    },
                                    List.of(8, 21, 23, 41, 42, 43),
                                    List.of(3, 5, 11, 16, 32, 38),
                                    List.of(7, 11, 16, 35, 36, 44)
                            );
                        }
                );
        assertThat(output()).contains(ERROR_WINNING_MESSAGE);
    }

    @DisplayName("당첨 번호가 로또 번호 범위를 벗어나면 예외가 발생한다.")
    @Test
    void 단위_테스트_2_2() {
        assertThatExceptionOfType(NoSuchElementException.class)
                .isThrownBy(() -> {
                            assertRandomUniqueNumbersInRangeTest(
                                    () -> {
                                        run("3000", "1,100,3,4,5,6");
                                        assertThat(output()).contains(
                                                "8개를 구매했습니다.",
                                                "[8, 21, 23, 41, 42, 43]",
                                                "[3, 5, 11, 16, 32, 38]",
                                                "[7, 11, 16, 35, 36, 44]"
                                        );
                                    },
                                    List.of(8, 21, 23, 41, 42, 43),
                                    List.of(3, 5, 11, 16, 32, 38),
                                    List.of(7, 11, 16, 35, 36, 44)
                            );
                        }
                );
        assertThat(output()).contains(ERROR_WINNING_MESSAGE);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
