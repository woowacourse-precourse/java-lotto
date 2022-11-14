package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class OutputTest extends NsTest {
    @DisplayName("7000원 구입 5등 두번 4등 한번")
    @Test
    void OutputTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("7000", "4,5,6,11,13,14", "7");
                    assertThat(output()).contains(
                            "7개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]",
                            "[4, 5, 6, 7, 8, 9]",
                            "[1, 2, 4, 11, 13, 14]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "3개 일치 (5,000원) - 2개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 857.1%입니다."
                    );
                },
                List.of(6, 5, 4, 3, 2, 1),
                List.of(9, 8, 6, 7, 5, 4),
                List.of(1, 2, 14, 4, 13, 11),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
