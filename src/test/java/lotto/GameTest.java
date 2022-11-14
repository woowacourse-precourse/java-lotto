package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static lotto.Game.makeWinning;
import static lotto.Game.winning;
import static org.assertj.core.api.Assertions.assertThat;

public class GameTest extends NsTest {
    @Test
    void makeWinningTest(){
        makeWinning("1,2,3,4,5,6");
        assertThat(winning).isEqualTo(
                List.of(1,2,3,4,5,6)
        );
    }

    @Test
    void resultViewTest() {
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

    @Test
    void allWinningCaseTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("15000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "3개 일치 (5,000원) - 5개",
                            "4개 일치 (50,000원) - 4개",
                            "5개 일치 (1,500,000원) - 3개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 2개",
                            "6개 일치 (2,000,000,000원) - 1개"
                    );
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 6, 7),
                List.of(1, 2, 3, 4, 5, 42),
                List.of(1, 2, 3, 4, 5, 40),
                List.of(1, 2, 3, 4, 5, 41),
                List.of(1, 2, 3, 4, 8, 9),
                List.of(1, 2, 3, 4, 8, 9),
                List.of(1, 2, 3, 4, 8, 9),
                List.of(1, 2, 3, 4, 8, 9),
                List.of(1, 2, 3, 9, 10, 11),
                List.of(1, 2, 3, 9, 10, 11),
                List.of(1, 2, 3, 9, 10, 11),
                List.of(1, 2, 3, 9, 10, 11),
                List.of(1, 2, 3, 9, 10, 11)
        );
    }
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
