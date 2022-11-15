package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoGameTest extends NsTest {
    @Test
    void 일치_기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]", // 6개
                            "[1, 2, 3, 4, 5, 7]",  // 5개 + 보너스
                            "[1, 2, 3, 4, 5, 37]", // 5개
                            "[1, 2, 3, 4, 26, 27]",  // 4개
                            "[1, 2, 3, 7, 9, 18]",  // 3개
                            "[1, 2, 9, 10, 11, 12]",  // 2개
                            "[1, 9, 10, 11, 12, 13]", // 1개
                            "[17, 18, 19, 20, 21, 22]", // 0개
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 1개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 253944.4%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 5, 37),
                List.of(1, 2, 3, 4, 27, 26),
                List.of(1, 2, 3, 7, 9, 18),
                List.of(1, 2, 9, 10, 11, 12),
                List.of(1, 9, 10, 11, 12, 13),
                List.of(17, 18, 19, 20, 21, 22)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
