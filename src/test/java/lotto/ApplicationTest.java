package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.constant.Constants.*;
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

    @DisplayName("1등 1개, 2등 1개")
    @Test
    void 기능_테스트2() {
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
                            "[1, 2, 3, 4, 5, 7]",
                            "[1, 2, 3, 4, 5, 6]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 25375000.0%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @DisplayName("1등 1개, 2등 2개")
    @Test
    void 기능_테스트3() {
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
                            "[1, 3, 4, 5, 6, 7]",
                            "[1, 2, 3, 4, 5, 7]",
                            "[1, 2, 3, 4, 5, 6]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 2개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 25750000.0%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(1, 3, 4, 5, 6, 7),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @DisplayName("1등 1개, 2등 1개, 3등 2개 그리고 주어진 배열 순서가 정렬되어 있지 않은 경우")
    @Test
    void 기능_테스트4() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[1, 3, 4, 5, 6, 9]",
                            "[2, 3, 4, 5, 6, 9]",
                            "[1, 2, 3, 4, 5, 7]",
                            "[1, 2, 3, 4, 5, 6]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 2개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 25412500.0%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(1, 3, 4, 5, 6, 9),
                List.of(4, 3, 2, 5, 6, 9),
                List.of(5, 2, 3, 4, 1, 7),
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @DisplayName("예외테스트 - 보너스 번호가 당첨번호와 중복될 때")
    @Test
    void 예외_테스트2() {
        runException("8000", "1,2,3,4,5,6", "6");
        assertThat(output()).contains(DUPLICATED_NUMBER_ERROR_MESSAGE);
    }

    @DisplayName("예외테스트 - 당첨번호에 문자가 포함되어 있을 때")
    @Test
    void 예외_테스트4() {
        runException("8000", "1,2,3,4,k,6");
        assertThat(output()).contains(INVALID_INPUT_ERROR_MESSAGE);
    }

    @DisplayName("예외테스트 - 당첨번호에 범위를 벗어나는 값이 있을 때")
    @Test
    void 예외_테스트5() {
        runException("8000", "1,2,3,4,5,46");
        assertThat(output()).contains(OUT_OF_RANGE_ERROR_MESSAGE);
    }

    @DisplayName("예외테스트 - 당첨번호의 개수가 6개가 아닐 때")
    @Test
    void 예외_테스트6() {
        runException("8000", "1,2,3,4,5");
        assertThat(output()).contains(INVALID_LENGTH_ERROR_MESSAGE);
    }

    @DisplayName("예외테스트 - 당첨번호의 배열 입력이 이상할 때")
    @Test
    void 예외_테스트7() {
        runException("8000", "1, 2, 3, 4, 5, 6");
        assertThat(output()).contains(INVALID_INPUT_ERROR_MESSAGE);
    }

    @DisplayName("예외테스트 - 입력 금액이 0원 일때")
    @Test
    void 예외_테스트8() {
        runException("0");
        assertThat(output()).contains(INVALID_COST_ERROR_MESSAGE);
    }

    @DisplayName("예외테스트 - 당첨번호 입력 중 실수가 들어갈 때")
    @Test
    void 예외_테스트9() {
        runException("8000", "1.1,2,3,4,5,6");
        assertThat(output()).contains(INVALID_INPUT_ERROR_MESSAGE);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
