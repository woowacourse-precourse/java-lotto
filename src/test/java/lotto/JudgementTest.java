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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
