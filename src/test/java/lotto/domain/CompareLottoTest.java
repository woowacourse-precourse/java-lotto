package lotto.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class CompareLottoTest extends NsTest {
    @Test
    void 기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "8,21,23,41,42,43", "4");
                    assertThat(output()).contains(
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 200000000%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43)
        );
    }

    @Test
    void 예외_당첨번호_테스트() {
        assertSimpleTest(() -> {
            runException("1000", "123456", "7");
            assertThat(output()).contains(ExceptionMessage.notFitSize.message);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}