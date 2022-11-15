package lotto.model.machine;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;

import lotto.Application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class NumbersMatchRepositoryTest extends NsTest {

    @Nested
    @DisplayName("NumbersMatchRepository Class")
    class NumbersMatchRepositoryKoTest {

        @Nested
        @DisplayName("compareLotto method")
        class DescribeCompareLotto {

            @DisplayName("works well")
            @Test
            void compareLotto() {
                assertRandomUniqueNumbersInRangeTest(
                    () -> {
                        run("8000", "1,2,3,4,5,6", "7");
                        assertThat(output()).contains(
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개"
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
        }

        @Nested
        @DisplayName("showWinningHistory method")
        class DescribeShowWinningHistory {

            @DisplayName("works well")
            @Test
            void showWinningHistory() {

                assertRandomUniqueNumbersInRangeTest(
                    () -> {
                        run("8000", "1,2,3,4,5,6", "7");
                        assertThat(output()).contains(
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개"
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
        }

        @Nested
        @DisplayName("showYield method")
        class DescribeShowYield {

            @DisplayName("works well")
            @Test
            void showYield() {
                assertRandomUniqueNumbersInRangeTest(
                    () -> {
                        run("8000", "1,2,3,4,5,6", "7");
                        assertThat(output()).contains(
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
        }
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}