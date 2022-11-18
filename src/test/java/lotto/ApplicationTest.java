package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(strings = {"asdf", "1000a", "1asdf0", "sd8asd"})
    @DisplayName("User 돈 입력 문자 예외 테스트")
    void 유저_돈_입력_예외테스트(String money) {
        run(money);
        assertThat(output()).contains("[ERROR] 숫자만 입력해주세요");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1235", "1345", "1234", "1500"})
    @DisplayName("User 돈 입력단위 예외 테스트")
    void 유저_돈_입력단위_예외테스트(String money) {
        run(money);
        assertThat(output()).contains("[ERROR] 1000원 단위로 입력해주세요");
    }
    @Test
    @DisplayName("Lotto 구입 테스트")
    void com_Lotto_구입_테스트() {
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
                            "[1, 3, 5, 14, 22, 45]"
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

    @ParameterizedTest
    @DisplayName("로또 승리 조건 예외 테스트(갯수)")
    @ValueSource(strings = {"1,2,3,4,5,6,7", "1,2,3,4,5"})
    void 당첨_조건_로또_개수_테스트(String numbers) {
        run("8000", numbers);
        assertThat(output()).contains(
                "[ERROR] 6개의 숫자를 입력해주세요"
        );
    }
    @ParameterizedTest
    @DisplayName("로또 승리 조건 예외 테스트(중복)")
    @ValueSource(strings = {"1,1,3,4,5,5", "1,2,2,4,5,7"})
    void 당첨_조건_로또_중복_테스트(String numbers) {
        run("8000", numbers);
        assertThat(output()).contains(
                "[ERROR] 중복되지 않은 숫자들을 넣어주세요"
        );
    }
    @ParameterizedTest
    @DisplayName("로또 당첨 조건 예외 테스트(범위)")
    @ValueSource(strings = {"1,2,3,4,46,5", "1,3,2,47,5,7"})
    void 당첨_조건_로또_범위_테스트(String numbers) {
        run("8000", numbers);
        assertThat(output()).contains(
                "[ERROR] 1~45의 숫자를 넣어주세요"
        );
    }

    @ParameterizedTest
    @DisplayName("보너스 숫자 조건 테스트")
    @ValueSource(strings = {"c", "z"})
    void 보너스_숫자_조건_테스트(String bonus) {
        run("8000", "1,2,3,4,5,6", bonus);
        assertThat(output()).contains(
                "[ERROR] 숫자만 입력해주세요"
        );
    }
    @ParameterizedTest
    @DisplayName("보너스 범위 조건 테스트")
    @ValueSource(strings = {"0", "46"})
    void 보너스_범위_조건_테스트(String bonus) {
        run("8000", "1,2,3,4,5,6", bonus);
        assertThat(output()).contains(
                "[ERROR] 1~45의 숫자만 입력해주세요"
        );
    }
    @ParameterizedTest
    @DisplayName("보너스 중복 조건 테스트")
    @ValueSource(strings = {"5", "4"})
    void 보너스_중복_조건_테스트(String bonus) {
        run("8000", "1,2,3,4,5,6", bonus);
        assertThat(output()).contains(
                "[ERROR] 중복되지 않은 숫자를 당첨번호로 입력해주세요"
        );
    }

    @Test
    @DisplayName("통계 출력 테스트")
    void 통계_출력_테스트() {
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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
