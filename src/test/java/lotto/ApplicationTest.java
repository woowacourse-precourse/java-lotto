package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(() -> {
                run("8000", "1,2,3,4,5,6", "7");
                assertThat(output()).contains("8개를 구매했습니다.", "[8, 21, 23, 41, 42, 43]",
                    "[3, 5, 11, 16, 32, 38]", "[7, 11, 16, 35, 36, 44]", "[1, 8, 11, 31, 41, 42]",
                    "[13, 14, 16, 38, 42, 45]", "[7, 11, 30, 40, 42, 43]", "[2, 13, 22, 32, 38, 45]",
                    "[1, 3, 5, 14, 22, 45]", "3개 일치 (5,000원) - 1개", "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 0개", "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                    "6개 일치 (2,000,000,000원) - 0개", "총 수익률은 62.5%입니다.");
            }, List.of(8, 21, 23, 41, 42, 43), List.of(3, 5, 11, 16, 32, 38),
            List.of(7, 11, 16, 35, 36, 44), List.of(1, 8, 11, 31, 41, 42),
            List.of(13, 14, 16, 38, 42, 45), List.of(7, 11, 30, 40, 42, 43),
            List.of(2, 13, 22, 32, 38, 45), List.of(1, 3, 5, 14, 22, 45));
    }

    @Test
    void 기능_테스트2() {
        assertRandomUniqueNumbersInRangeTest(() -> {
                run("5000", "1,2,3,4,5,6", "7");
                assertThat(output()).contains("5개를 구매했습니다.", "[1, 2, 3, 4, 5, 6]", "[1, 2, 3, 4, 5, 7]",
                    "[1, 2, 7, 9, 23, 45]", "[10, 11, 12, 13, 15, 16]", "[40, 41, 42, 43, 44, 45]",
                    "3개 일치 (5,000원) - 0개", "4개 일치 (50,000원) - 0개", "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개", "6개 일치 (2,000,000,000원) - 1개",
                    "총 수익률은 40,600,000%입니다.");
            }, List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 7, 3, 4, 5), List.of(9, 2, 45, 23, 1, 7),
            List.of(10, 11, 12, 13, 15, 16), List.of(45, 42, 41, 40, 43, 44));
    }

    @Test
    void 기능_테스트3() {
        assertRandomUniqueNumbersInRangeTest(() -> {
                run("1000", "16,15,14,13,12,11", "20");
                assertThat(output()).contains("1개를 구매했습니다.", "[11, 13, 16, 20, 30, 50]",
                    "3개 일치 (5,000원) - 1개", "4개 일치 (50,000원) - 0개", "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개", "6개 일치 (2,000,000,000원) - 0개",
                    "총 수익률은 500%입니다.");
            }, List.of(20, 30, 13, 50, 16, 11));
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("구입 금액 검증 테스트 - 문자일 때 에러")
    void getLottoCount_1() {
        // given
        String string = "abc";

        // when

        // then
        assertSimpleTest(() -> {
            runException(string);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("구입 금액 검증 테스트 - 소수일 때 에러")
    void getLottoCount_2() {
        // given
        String string = "1.23";

        // when

        // then
        assertSimpleTest(() -> {
            runException(string);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("구입 금액 검증 테스트 - 0일 때 에러")
    void getLottoCount_3() {
        // given
        String string = "0";

        // when

        // then
        assertSimpleTest(() -> {
            runException(string);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("구입 금액 검증 테스트 - 음수일 때 에러")
    void getLottoCount_4() {
        // given
        String string = "-123";

        // when

        // then
        assertSimpleTest(() -> {
            runException(string);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("구입 금액 검증 테스트 - 1,000원으로 나누어떨어지지 않을 때 에러")
    void getLottoCount_5() {
        // given
        String string = "8200";

        // when

        // then
        assertSimpleTest(() -> {
            runException(string);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("당첨 번호 검증 테스트 - 올바른 형식이 아닐 때 에러 1")
    void getWinningLotto_1() {
        // given
        String string = "123 456 789 101 121 314";

        // when

        // then
        assertSimpleTest(() -> {
            runException("8000", string);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("당첨 번호 검증 테스트 - 올바른 형식이 아닐 때 에러 2")
    void getWinningLotto_2() {
        // given
        String string = "ab,12,4g,bb,67,11";

        // when

        // then
        assertSimpleTest(() -> {
            runException("8000", string);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("당첨 번호 검증 테스트 - 올바른 범위가 아닐 때 에러 1")
    void getWinningLotto_3() {
        // given
        String string = "1,2,0,3,4,5";

        // when

        // then
        assertSimpleTest(() -> {
            runException("8000", string);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("당첨 번호 검증 테스트 - 올바른 범위가 아닐 때 에러 2")
    void getWinningLotto_4() {
        // given
        String string = "1,2,3,4,5,46";

        // when

        // then
        assertSimpleTest(() -> {
            runException("8000", string);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("당첨 번호 검증 테스트 - 당첨 번호의 개수가 6개가 아닐 때 에러")
    void getWinningLotto_5() {
        // given
        String string = "1,2,3,4,5";

        // when

        // then
        assertSimpleTest(() -> {
            runException("8000", string);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("당첨 번호 검증 테스트 - 당첨 번호 중 중복이 있을 때 에러")
    void getWinningLotto_6() {
        // given
        String string = "1,2,3,4,5,1";

        // when

        // then
        assertSimpleTest(() -> {
            runException("8000", string);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("보너스 번호 검증 테스트 - 수 형식이 아닐 때 에러")
    void getBonusNumber_1() {
        // given
        String string = "12c4";

        // when

        // then
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", string);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("보너스 번호 검증 테스트 - 범위를 벗어날 때 에러 1")
    void getBonusNumber_2() {
        // given
        String string = "0";

        // when

        // then
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", string);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("보너스 번호 검증 테스트 - 범위를 벗어날 때 에러 2")
    void getBonusNumber_3() {
        // given
        String string = "46";

        // when

        // then
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", string);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("당첨 로또 번호와 보너스 번호 검증 테스트 - 둘 사이에 중복이 존재한다면 에러")
    void validateWinningLottoAndBonusNumber() {
        // given
        String string = "1";

        // when

        // then
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", string);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
