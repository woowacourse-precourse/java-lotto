package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";


    @Test
    void 구입금액_영어입력시_예외_테스트() {
        assertSimpleTest(() -> {
            runException("abc");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 구입금액_한글입력시_예외_테스트() {
        assertSimpleTest(() -> {
            runException("가나다");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 구입금액_영어숫자_혼합입력시_예외_테스트() {
        assertSimpleTest(() -> {
            runException("1a2b3c4");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 구입금액_1000의배수_예외_테스트() {
        assertSimpleTest(() -> {
            runException("2500");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 구입금액_성공_테스트() {
        assertSimpleTest(() -> {
            run("5000", "1,2,3,4,5,6", "7");
            assertThat(output()).contains("5개를 구매했습니다.");
        });
    }

    @Test
    void 로또_정렬_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("3000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "3개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]"
                    );
                },
                List.of(43, 42, 41, 23, 21, 8),
                List.of(16, 32, 38, 3, 5, 11),
                List.of(7, 11, 16, 35, 36, 44)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}



