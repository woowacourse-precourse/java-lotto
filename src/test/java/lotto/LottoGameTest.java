package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGameTest extends NsTest {
    @DisplayName("6개 일치 1개, 3개 일치 1개, 총 수익률이 25000062.5%인 경우")
    @Test
    void normal_operating1() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]",
                            "[1, 2, 3, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 33, 14, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 25000062.5%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 33, 14, 22, 45)
        );
    }

    @DisplayName("5개 일치 1개, 총 수익률이 25000062.5%인 경우")
    @Test
    void normal_operating2() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 8]",
                            "[1, 2, 44, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 33, 14, 22, 45]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 1개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 18750.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 8),
                List.of(1, 2, 44, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 33, 14, 22, 45)
        );
    }

    @DisplayName("3개 일치 8개, 총 수익률 500%인 경우")
    @Test
    void normal_operating3() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[1, 2, 3, 40, 15, 26]",
                            "[4, 5, 6, 12, 32, 38]",
                            "[1, 3, 5, 35, 36, 44]",
                            "[2, 4, 6, 31, 41, 42]",
                            "[1, 2, 6, 38, 42, 45]",
                            "[3, 4, 6, 40, 42, 43]",
                            "[2, 13, 22, 32, 3, 4]",
                            "[1, 3, 33, 14, 22, 5]",
                            "3개 일치 (5,000원) - 8개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 500.0%입니다."
                    );
                },
                List.of(1, 2, 3, 40, 15, 26),
                List.of(4, 5, 6, 12, 32, 38),
                List.of(1, 3, 5, 35, 36, 44),
                List.of(2, 4, 6, 31, 41, 42),
                List.of(1, 2, 6, 38, 42, 45),
                List.of(3, 4, 6, 40, 42, 43),
                List.of(2, 13, 22, 32, 3, 4),
                List.of(1, 3, 33, 14, 22, 5)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
