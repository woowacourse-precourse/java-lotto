package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.util.ConstValue.LottoConst.ERROR_PREFIX;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {

    @DisplayName("전체_기능_테스트1 -> 8000원치 구매")
    @Test
    void 전체_기능_테스트1() {
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

    @DisplayName("전체_기능_테스트2 -> 5000원치 구매")
    @Test
    void 전체_기능_테스트2() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("5000", "1,8,11,41,42,44", "7");
                    assertThat(output()).contains(
                            "5개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "3개 일치 (5,000원) - 2개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 1개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 30200.0%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45)
        );
    }

    @DisplayName("로또_구매비용_지불_예외_테스트")
    @Test
    void 로또_구매비용_지불_예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_PREFIX);
        });
    }

    @DisplayName("당첨_번호_입력_잘못된_형식_예외_테스트")
    @Test
    void 당첨_번호_입력_잘못된_형식_예외_테스트() {
        assertSimpleTest(() -> {
            runException("14000", "1,2,3,4,5,a");
            assertThat(output()).contains(ERROR_PREFIX);
        });
    }

    @DisplayName("당첨_번호_입력_범위를_벗어난_값_예외_테스트1")
    @Test
    void 당첨_번호_입력_범위를_벗어난_값_예외_테스트1() {
        assertSimpleTest(() -> {
            runException("14000", "1,2,3,4,5,46");
            assertThat(output()).contains(ERROR_PREFIX);
        });
    }

    @DisplayName("당첨_번호_입력_범위를_벗어난_값_예외_테스트2")
    @Test
    void 당첨_번호_입력_범위를_벗어난_값_예외_테스트2() {
        assertSimpleTest(() -> {
            runException("14000", "0,2,3,4,5,45");
            assertThat(output()).contains(ERROR_PREFIX);
        });
    }

    @DisplayName("보너스번호_입력_로또번호와_중복_예외_테스트")
    @Test
    void 보너스번호_입력_로또번호와_중복_예외_테스트() {
        assertSimpleTest(() -> {
            runException("14000", "1,2,3,4,5,45", "45");
            assertThat(output()).contains(ERROR_PREFIX);
        });
    }

    @DisplayName("보너스번호_입력_범위를_벗어난_값_예외_테스트")
    @Test
    void 보너스번호_입력_범위를_벗어난_값_예외_테스트() {
        assertSimpleTest(() -> {
            runException("14000", "1,2,3,4,5,45", "46");
            assertThat(output()).contains(ERROR_PREFIX);
        });
    }

    @DisplayName("보너스번호_입력_잘못된_형식_예외_테스트")
    @Test
    void 보너스번호_입력_잘못된_형식_예외_테스트() {
        assertSimpleTest(() -> {
            runException("14000", "1,2,3,4,5,45", "abc");
            assertThat(output()).contains(ERROR_PREFIX);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
