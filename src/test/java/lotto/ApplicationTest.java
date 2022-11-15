package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

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

    @DisplayName("로또를 10개 구매하고 당첨 결과를 출력한다.")
    @Test
    void applicationTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("10000", "1, 3, 20, 5, 8, 25", "7");
                    assertThat(output()).contains(
                            "10개를 구매했습니다.",
                            "[7, 28, 31, 35, 37, 44]",
                            "[8, 9, 15, 26, 27, 30]",
                            "[10, 12, 16, 31, 37, 44]",
                            "[5, 8, 20, 34, 37, 38]",
                            "[10, 17, 32, 33, 38, 42]",
                            "[6, 20, 23, 25, 33, 34]",
                            "[5, 8, 25, 32, 41, 42]",
                            "[1, 3, 20, 26, 30, 33]",
                            "[3, 16, 17, 25, 34, 38]",
                            "[10, 24, 27, 29, 30, 41]",
                            "3개 일치 (5,000원) - 3개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 150.0%입니다."
                    );
                },
                List.of(7, 28, 31, 35, 37, 44),
                List.of(8, 9, 15, 26, 27, 30),
                List.of(10, 12, 16, 31, 37, 44),
                List.of(5, 8, 20, 34, 37, 38),
                List.of(10, 17, 32, 33, 38, 42),
                List.of(6, 20, 23, 25, 33, 34),
                List.of(5, 8, 25, 32, 41, 42),
                List.of(1, 3, 20, 26, 30, 33),
                List.of(3, 16, 17, 25, 34, 38),
                List.of(10, 24, 27, 29, 30, 41)
        );
    }

    @DisplayName("구입 금액이 0원 이하면 예외를 발생한다.")
    @Test
    void moneyInputByNotMoreThanZero() {
        assertSimpleTest(() -> {
            runException("0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외를 발생한다.")
    @Test
    void moneyInputByWrongUnit() {
        assertSimpleTest(() -> {
            runException("1230");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
