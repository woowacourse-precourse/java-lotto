package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

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
    void 잔액반환_보너스_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("9432", "19, 40, 21, 11, 30, 3", "36");
                    assertThat(output()).contains(
                            "입력된 구입금액 9432원 에서 로또 구매 후 잔액이 존재합니다.",
                            "432원을 반환합니다. 반환된 값은 수익률 계산에서 제외됩니다.",
                            "9개를 구매했습니다.",
                            "[21, 3, 12, 5, 8, 19]",
                            "[12, 43, 41, 24, 8, 44]",
                            "[25, 15, 40, 29, 32, 31]",
                            "[28, 23, 19, 21, 3, 11]",
                            "[22, 25, 28, 11, 33, 39]",
                            "[12, 39, 13, 41, 10, 43]",
                            "[32, 42, 25, 26, 13, 19]",
                            "[14, 26, 38, 35, 40, 5]",
                            "[19, 40, 21, 11, 30, 36]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 333944.4%입니다."
                    );
                },
                List.of(21, 3, 12, 5, 8, 19),
                List.of(12, 43, 41, 24, 8, 44),
                List.of(25, 15, 40, 29, 32, 31),
                List.of(28, 23, 19, 21, 3, 11),
                List.of(22, 25, 28, 11, 33, 39),
                List.of(12, 39, 13, 41, 10, 43),
                List.of(32, 42, 25, 26, 13, 19),
                List.of(14, 26, 38, 35, 40, 5),
                List.of(19, 40, 21, 11, 30, 36)
        );
    }

    @Test
    void 예외_테스트_문자포함() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_음수() {
        assertSimpleTest(() -> {
            runException("-5000");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_잔액() {
        assertSimpleTest(() -> {
            runException("3550");
            assertThat(output()).contains("잔액");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
