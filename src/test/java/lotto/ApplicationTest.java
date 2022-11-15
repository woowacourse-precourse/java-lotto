package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
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
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
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

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    //내가 만든 테스트들
    @Test
    void 예외_로또구매할금액_숫자가아닌입력() {
        assertSimpleTest(() -> {
            runException("asdbkfsa");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Test
    void 예외_로또구매할금액_로또금액보다작은금액() {
        assertSimpleTest(() -> {
            runException("999");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_로또구매할금액_로또금액의배수가아닌금액() {
        assertSimpleTest(() -> {
            runException("9200");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }


    @Test
    void 예외_로또번호입력오류_길이초과() {
        assertSimpleTest(() -> {
            runException("10000", "1,2,3,4,5,6,7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_로또번호입력오류_구분자사이에숫자없음() {
        assertSimpleTest(() -> {
            runException("10000", "1,2,3,4,,67");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_로또번호입력오류_숫자들범위체크() {
        assertSimpleTest(() -> {
            runException("10000", "1,2,3,4,5,67");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }


    @Test
    void 예외_보너스번호_숫자아닌입력1() {
        assertSimpleTest(() -> {
            runException("10000", "1,2,3,4,5,6", "a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Test
    void 예외_보너스번호_숫자아닌입력2() {
        assertSimpleTest(() -> {
            runException("10000", "1,2,3,4,5,6", "ad");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Test
    void 예외_보너스번호_숫자범위벗어난입력1() {
        assertSimpleTest(() -> {
            runException("10000", "1,2,3,4,5,6", "46");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Test
    void 예외_보너스번호_숫자범위벗어난입력2() {
        assertSimpleTest(() -> {
            runException("10000", "1,2,3,4,5,6", "0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Test
    void 예외_보너스번호_숫자범위벗어난입력3() {
        assertSimpleTest(() -> {
            runException("10000", "1,2,3,4,5,6", "-1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Test
    void 예외_보너스번호_당첨번호와중복된숫자입력() {
        assertSimpleTest(() -> {
            runException("10000", "1,2,3,4,5,6", "5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }


}
