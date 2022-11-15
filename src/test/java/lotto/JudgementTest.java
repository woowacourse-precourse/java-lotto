package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class JudgementTest extends NsTest {
    @DisplayName("추첨 번호와 당첨 번호가 3개 일치하는 경우")
    @Test
    void compareLotteryNumberAndLottoToSuccessful() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,3,5,7,9,11", "12");
                    assertThat(output()).contains(
                            "3개 일치 (5,000원) - 1개"
                    );
                },
                List.of(1, 3, 5, 20, 21, 22)
        );
    }

    @DisplayName("8000원 어치를 구매하여 5,000원 당첨이 1번이면 수익률은 62.5%가 된다.")
    @Test
    void computeReturnRateToSuccessful() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,3,5,7,9,11", "12");
                    assertThat(output()).contains(
                            "총 수익률은 62.5%입니다."
                    );
                },
                List.of(1, 3, 5, 20, 21, 22),
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 10, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
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
