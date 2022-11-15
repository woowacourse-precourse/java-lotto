package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
    void 기능_테스트2() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("10000", "6,7,9,11,17,18", "45");
                    assertThat(output()).contains(
                            "10개를 구매했습니다.",
                            "[2, 8, 10, 22, 24, 26]",
                            "[3, 9, 11, 16, 32, 35]",
                            "[6, 10, 16, 33, 37, 38]",
                            "[3, 4, 15, 17, 18, 44]",
                            "[1, 3, 15, 24, 31, 36]",
                            "[8, 22, 26, 27, 31, 45]",
                            "[4, 5, 21, 31, 41, 43]",
                            "[6, 7, 9, 11, 17, 18]",
                            "[1, 6, 9, 11, 27, 45]",
                            "[2, 16, 17, 27, 32, 42]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 20000050.0%입니다."
                    );
                },
                List.of(2, 8, 10, 22, 24, 26),
                List.of(3, 9, 11, 16, 32, 35),
                List.of(6, 10, 16, 33, 37, 38),
                List.of(3, 4, 15, 17, 18, 44),
                List.of(1, 3, 15, 24, 31, 36),
                List.of(8, 22, 26, 27, 31, 45),
                List.of(4, 5, 21, 31, 41, 43),
                List.of(6, 7, 9, 11, 17, 18),
                List.of(1, 6, 9, 11, 27, 45),
                List.of(2, 16, 17, 27, 32, 42)
        );
    }

    @Test
    void 기능_테스트3() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("5000", "3,7,12,19,26,45", "35");
                    assertThat(output()).contains(
                            "5개를 구매했습니다.",
                            "[23, 30, 32, 38, 39, 45]",
                            "[4, 5, 18, 23, 29, 32]",
                            "[8, 9, 10, 15, 42, 44]",
                            "[3, 7, 12, 19, 26, 43]",
                            "[3, 7, 12, 19, 26, 35]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 1개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 630000.0%입니다."
                    );
                },
                List.of(23, 30, 32, 38, 39, 45),
                List.of(4, 5, 18, 23, 29, 32),
                List.of(8, 9, 10, 15, 42, 44),
                List.of(3, 7, 12, 19, 26, 43),
                List.of(3, 7, 12, 19, 26, 35)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000j", " ", "-1000"})
    void 예외_로또_구입_금액_문자_포함(String purchaseMoney) {
        assertSimpleTest(() -> {
            runException(purchaseMoney);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"999", "0"})
    void 예외_로또_구입_금액_최소_금액_미만(String purchaseMoney) {
        assertSimpleTest(() -> {
            runException(purchaseMoney);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"9999", "1009"})
    void 예외_로또_구입_금액_1000_단위(String purchaseMoney) {
        assertSimpleTest(() -> {
            runException(purchaseMoney);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5.6", "1,2,3,4,5a,6", "1,2,.3,4,5,6"})
    void 예외_당첨_번호_숫자_쉼표_이외_문자_포함(String winningNumbers) {
        assertSimpleTest(() -> {
            runException("1000", winningNumbers);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "0,1,2,3,4,5,6"})
    void 예외_테스트_당첨_번호_갯수(String winningNumbers) {
        assertSimpleTest(() -> {
            runException("1000", winningNumbers, "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"0,2,3,4,5,6", "1,2,3,4,5,46"})
    void 예외_당첨_번호_범위(String winningNumbers) {
        assertSimpleTest(() -> {
            runException("1000", winningNumbers, "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,5", "1,1,2,3,4,5"})
    void 예외_당첨_번호_중복(String winningNumbers) {
        assertSimpleTest(() -> {
            runException("1000", winningNumbers, "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000j", " ", "-1000"})
    void 예외_보너스_번호_문자_포함(String bonusNumber) {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", bonusNumber);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "46"})
    void 예외_보너스_번호_범위(String bonusNumber) {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", bonusNumber);
            assertThat(output()).contains(ERROR_MESSAGE);
            // TODO
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6"})
    void 예외_보너스_번호_중복(String bonusNumber) {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", bonusNumber);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
