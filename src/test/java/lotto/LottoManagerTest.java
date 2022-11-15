package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;


class LottoManagerTest extends NsTest{
    private static final String ERROR_MESSAGE = "[ERROR]";
    
    @Test
    void 기능_테스트_2등상() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,3,5,14,22,30", "45");
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
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 375000.0%입니다."
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
    void 예외_테스트_구매금액_범위() {
        assertSimpleTest(() -> {
            runException("1500");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
        assertSimpleTest(() -> {
            runException("-1000");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    
    @Test
    public void 예외_테스트_당첨번호_범위() throws Exception{
        assertSimpleTest(() -> {
            runException("1000", "100,101,102,103,104,105");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
     }

    @Test
    public void 예외_테스트_보너스번호_범위() throws Exception{
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "100");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Test
    public void 예외_테스트_보너스번호_중복() throws Exception{
        assertSimpleTest(() -> {
            runException("1000", "6,1,2,3,4,5", "2");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}