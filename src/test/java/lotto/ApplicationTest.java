package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.constant.LottoConstant.ExceptionMessage.*;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {

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
                    run("10000", "23,6,45,14,34,12", "7");
                    assertThat(output()).contains(
                            "10개를 구매했습니다.",
                            "[11, 12, 15, 18, 20, 44]",
                            "[18, 19, 22, 26, 39, 44]",
                            "[6, 12, 14, 23, 34, 45]",
                            "[6, 11, 23, 28, 29, 34]",
                            "[1, 14, 25, 28, 33, 40]",
                            "[21, 24, 26, 32, 34, 40]",
                            "[5, 11, 23, 30, 35, 44]",
                            "[13, 21, 29, 30, 37, 38]",
                            "[9, 21, 22, 30, 35, 45]",
                            "[4, 9, 17, 18, 29, 31]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 20000050.0%입니다."
                    );
                },
                List.of(18, 20, 44, 11, 12, 15),
                List.of(22, 26, 39, 18, 19, 44),
                List.of(12, 14, 23, 6, 34, 45),
                List.of(11, 23, 28, 6, 29, 34),
                List.of(28, 33, 40, 1, 14, 25),
                List.of(32, 34, 40, 21, 24, 26),
                List.of(5, 11, 44, 23, 30, 35),
                List.of(29, 30, 37, 13, 21, 38),
                List.of(21, 22, 30, 9, 35, 45),
                List.of(18, 29, 31, 4, 9, 17)
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

    @Test
    void 예외_테스트_로또_구입_금액_숫자_이외_문자_포함() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(PREFIX + INVALID_INPUT_ONLY_NUMBER);
        });
    }

    @Test
    void 예외_테스트_로또_구입_금액_최소_금액() {
        assertSimpleTest(() -> {
            runException("700");
            assertThat(output()).contains(PREFIX + INVALID_PURCHASE_MONEY_MIN);
        });
    }

    @Test
    void 예외_테스트_로또_구입_금액_단위() {
        assertSimpleTest(() -> {
            runException("5500");
            assertThat(output()).contains(PREFIX + INVALID_PURCHASE_MONEY_UNIT);
        });
    }

    @Test
    void 예외_테스트_당첨_번호_숫자_쉼표_이외_문자_포함() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5.6");
            assertThat(output()).contains(PREFIX + INVALID_INPUT_ONLY_NUMBER_COMMA);
        });
    }

    @Test
    void 예외_테스트_당첨_번호_갯수() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6,7", "8");
            assertThat(output()).contains(PREFIX + INVALID_LOTTO_NUMBER_COUNT);
        });
    }

    @Test
    void 예외_테스트_당첨_번호_범위() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,50", "7");
            assertThat(output()).contains(PREFIX + INVALID_LOTTO_NUMBER_RANGE);
        });
    }

    @Test
    void 예외_테스트_당첨_번호_중복() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,5", "7");
            assertThat(output()).contains(PREFIX + INVALID_LOTTO_NUMBER_DUPLICATION);
        });
    }

    @Test
    void 예외_테스트_보너스_번호_숫자_이외_문자_포함() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "7a");
            assertThat(output()).contains(PREFIX + INVALID_INPUT_ONLY_NUMBER);
        });
    }

    @Test
    void 예외_테스트_보너스_번호_범위() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "50");
            assertThat(output()).contains(PREFIX + INVALID_LOTTO_NUMBER_RANGE);
        });
    }

    @Test
    void 예외_테스트_보너스_번호_중복() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "6");
            assertThat(output()).contains(PREFIX + INVALID_BONUS_NUMBER_DUPLICATION);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
