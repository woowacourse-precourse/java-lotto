package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class CustomApplicationTest extends NsTest {
    @Test
    @DisplayName("기능테스트1")
    void function_test_one() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("5000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "5개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]",
                            "[1, 2, 3, 4, 5, 7]",
                            "[1, 2, 3, 4, 5, 9]",
                            "[1, 2, 3, 4, 9, 10]",
                            "[1, 2, 3, 10, 11, 12]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 1개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 40631100.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 5, 9),
                List.of(1, 2, 3, 4, 9, 10),
                List.of(1, 2, 3, 10, 11, 12)
        );
    }

    @Test
    @DisplayName("기능테스트2")
    void function_test_two() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("5000", "6,5,4,3,2,1", "7");
                    assertThat(output()).contains(
                            "5개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]",
                            "[1, 2, 3, 4, 5, 7]",
                            "[1, 2, 3, 4, 5, 9]",
                            "[1, 2, 3, 4, 9, 10]",
                            "[1, 2, 3, 10, 11, 12]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 1개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 40631100.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 5, 9),
                List.of(1, 2, 3, 4, 9, 10),
                List.of(1, 2, 3, 10, 11, 12)
        );
    }

    @Test
    @DisplayName("기능테스트3")
    void function_test_three() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("5000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "5개를 구매했습니다.",
                            "[1, 2, 3, 40, 41, 42]",
                            "[1, 2, 3, 10, 11, 12]",
                            "[1, 2, 3, 11, 12, 13]",
                            "[1, 2, 3, 14, 15, 16]",
                            "[1, 2, 3, 20, 21, 22]",
                            "3개 일치 (5,000원) - 5개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 500.0%입니다."
                    );
                },
                List.of(1, 2, 3, 40, 41, 42),
                List.of(1, 2, 3, 10, 11, 12),
                List.of(1, 2, 3, 11, 12, 13),
                List.of(1, 2, 3, 14, 15, 16),
                List.of(1, 2, 3, 20, 21, 22)
        );
    }

    @Test
    @DisplayName("기능테스트4")
    void function_test_four() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("5000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "5개를 구매했습니다.",
                            "[1, 2, 3, 40, 41, 42]",
                            "[1, 2, 3, 10, 11, 12]",
                            "[1, 2, 3, 11, 12, 13]",
                            "[1, 2, 3, 14, 15, 16]",
                            "[1, 2, 3, 20, 21, 22]",
                            "3개 일치 (5,000원) - 5개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 500.0%입니다."
                    );
                },
                List.of(2, 1, 3, 40, 41, 42),
                List.of(1, 2, 10, 3, 11, 12),
                List.of(13, 2, 3, 11, 12, 1),
                List.of(15, 2, 3, 14, 1, 16),
                List.of(20, 2, 3, 1, 21, 22)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
