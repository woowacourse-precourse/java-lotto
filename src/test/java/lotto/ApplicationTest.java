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
    void 유저_돈_입력_문자_예외_테스트(String money) {
        run(money);
        assertThat(output()).contains("[ERROR] Please input Number only");
    }

    @ParameterizedTest
    @ValueSource(strings = {"15300", "12345", "145321", "1234"})
    @DisplayName("User 돈 입력 단위 예외 테스트")
    void 유저_돈_입력_단위_예외_테스트(String money) {
        run(money);
        assertThat(output()).contains("[ERROR] Please enter in thousands");
    }


    @ParameterizedTest
    @ValueSource(strings = {"8000"})
    @DisplayName("Lotto 구매 테스트")
    void 컴퓨터_로또_구입_테스트(String money) {
        run(money);
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run(money);
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
    @DisplayName("로또 승리 조건 예외 테스트 ( 개수 )")
    @ValueSource(strings = {"1,2,3,4,5,6,7", "1,2,3,4,5"})
    void 승리_로또_개수_테스트(String numbers) {
        run("8000", numbers);
        assertThat(output()).contains(
                "[ERROR] Please input 6 numbers only"
        );
    }

    @ParameterizedTest
    @DisplayName("로또 승리 조건 예외 테스트 ( 숫자 )")
    @ValueSource(strings = {"1,2,3,4,5,a", "a,b,c,d,e,f"})
    void 승리_로또_숫자_테스트(String numbers) {
        run("8000", numbers);
        assertThat(output()).contains(
                "[ERROR] Please input Numbers only"
        );
    }

    @ParameterizedTest
    @DisplayName("로또 승리 조건 예외 테스트 ( 중복 )")
    @ValueSource(strings = {"1,2,3,4,5,5", "1,1,2,3,3,5"})
    void 승리_로또_중복_테스트(String numbers) {
        run("8000", numbers);
        assertThat(output()).contains(
                "[ERROR] Please input not duplicated numbers"
        );
    }

    @ParameterizedTest
    @DisplayName("로또 승리 조건 예외 테스트 ( 범위 )")
    @ValueSource(strings = {"1,2,3,4,5,0", "500,1,2,3,4,5"})
    void 승리_로또_범위_테스트(String numbers) {
        run("8000", numbers);
        assertThat(output()).contains(
                "[ERROR] Please input 1~45 numbers"
        );
    }
    @ParameterizedTest
    @DisplayName("로또 보너스 예외 테스트 ( 숫자 )")
    @ValueSource(strings = {"a", "b"})
    void 보너스_숫자_테스트(String bonus) {
        run("8000", "1,2,3,4,5,6", bonus);
        assertThat(output()).contains(
                "[ERROR] please input only numbers"
        );
    }

    @ParameterizedTest
    @DisplayName("로또 보너스 예외 테스트 ( 범위 )")
    @ValueSource(strings = {"0", "46"})
    void 보너스_범위_테스트(String bonus) {
        run("8000", "1,2,3,4,5,6", bonus);
        assertThat(output()).contains(
                "[ERROR] Please input 1~45 numbers"
        );
    }

    @ParameterizedTest
    @DisplayName("로또 보너스 예외 테스트 ( 중복 )")
    @ValueSource(strings = {"5", "4"})
    void 보너스_중복_테스트(String bonus) {
        run("8000", "1,2,3,4,5,6", bonus);
        assertThat(output()).contains(
                "[ERROR] Please input not duplicated with winning numbers"
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
