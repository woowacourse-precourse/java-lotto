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
    @DisplayName("공백이 있는 경우에도 제거하고 진행되어야 한다")
    void blankInputTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run(" 8000 ", "1, 2, 3, 4, 5, 6", " 7");
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
    @DisplayName("구입 금액이 숫자가 아닐 경우 오류가 나야 한다.")
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("구입 금액 입력이 비어있을 때 오류가 나야 한다")
    void emptyPurchaseCostTest() {
        assertSimpleTest(() -> {
            runException(" ");
            assertThat(output()).contains(ErrorType.EMPTY_STR.getErrorMsg());
        });
    }

    @Test
    @DisplayName("구입 금액이 1000의 배수가 아닐 경우 오류가 나야 한다.")
    void invalidPurchaseCostTest() {
        assertSimpleTest(() -> {
            runException("80001");
            assertThat(output()).contains(ErrorType.INVALID_PURCHASE_COST.getErrorMsg());
        });
    }

    @Test
    @DisplayName("당첨번호가 비어있을 때 오류가 나야 한다")
    void emptyWinningNumberTest() {
        assertSimpleTest(() -> {
            runException(" ");
            assertThat(output()).contains(ErrorType.EMPTY_STR.getErrorMsg());
        });
    }

    @Test
    @DisplayName("당첨번호가 숫자가 아닐 경우 오류가 나야 한다.")
    void invalidFormatWinningNumberTest() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,ㅁ");
            assertThat(output()).contains(ErrorType.INVALID_FORMAT.getErrorMsg());
        });
    }

    @Test
    @DisplayName("당첨번호가 중복될 경우 오류가 나야 한다.")
    void duplicateWinningNumberTest() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,5");
            assertThat(output()).contains(ErrorType.DUPLICATED_NUMBER.getErrorMsg());
        });
    }

    @Test
    @DisplayName("당첨번호의 길이가 다를 경우 오류가 나야 한다.")
    void invalidLengthWinningNumberTest() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5");
            assertThat(output()).contains(ErrorType.INVALID_LENGTH.getErrorMsg());
        });
    }

    @Test
    @DisplayName("당첨번호의 범위가 1 ~ 45가 아닐 경우 오류가 나야 한다.")
    void invalidRangeWinningNumberTest() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,46");
            assertThat(output()).contains(ErrorType.INVALID_RANGE.getErrorMsg());
        });
    }

    @Test
    @DisplayName("보너스 번호 입력이 비어있을 때 오류가 나야 한다")
    void emptyBonusNumberTest() {
        assertSimpleTest(() -> {
            runException(" ");
            assertThat(output()).contains(ErrorType.EMPTY_STR.getErrorMsg());
        });
    }

    @Test
    @DisplayName("보너스번호가 숫자가 아닐 경우 오류가 나야 한다.")
    void invalidFormatBonusNumberTest() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "a");
            assertThat(output()).contains(ErrorType.INVALID_FORMAT.getErrorMsg());
        });
    }

    @Test
    @DisplayName("당첨번호의 범위가 1 ~ 45가 아닐 경우 오류가 나야 한다.")
    void invalidRangeBonusNumberTest() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,45", "46");
            assertThat(output()).contains(ErrorType.INVALID_RANGE.getErrorMsg());
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
