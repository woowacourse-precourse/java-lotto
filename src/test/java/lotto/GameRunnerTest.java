package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.mvc.util.LottoGameStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameRunnerTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Override
    protected void runMain() {
        GameRunner.run(LottoGameStatus.PURCHASE_AMOUNT);
    }

    @Nested
    @DisplayName("run 메소드는")
    class RunMethodTest {

        @Test
        @DisplayName("만약 플레이어 입력이 모두 유효한 경우 로또 당첨 결과와 수익률을 반환한다.")
        void success_test() {
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

        @ParameterizedTest
        @ValueSource(strings = {"1000j", "a12", "@0000", "1 000"})
        @DisplayName("만약 구입 금액이 숫자가 아닌 경우 예외 메세지가 출력되고 애플리케이션이 종료된다.")
        void purchase_amount_invalid_number_format_exception_test(String invalidInput) {
            assertSimpleTest(() -> {
                runException(invalidInput);
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @ParameterizedTest
        @ValueSource(strings = {"1100", "100", "11090", "10001"})
        @DisplayName("만약 구입 금액이 1000원 단위가 아닌 경우 예외 메세지가 출력되고 애플리케이션이 종료된다.")
        void purchase_amount_invalid_number_unit_exception_test(String invalidInput) {
            assertSimpleTest(() -> {
                runException(invalidInput);
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @ParameterizedTest
        @ValueSource(strings = {"a,2,3,4,5,6", "@,2,3,4,5,6", " ,2,3,4,5,6"})
        @DisplayName("만약 당첨 번호가 숫자가 아닌 경우 예외 메세지가 출력되고 애플리케이션이 종료된다.")
        void winning_numbers_invalid_number_format_exception_test(String invalidInput) {
            assertSimpleTest(() -> {
                runException("1000", invalidInput);
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @ParameterizedTest
        @ValueSource(strings = {"1:2:3:4:5:6", "1@2@3@4@5@6"})
        @DisplayName("만약 당첨 번호의 구분자가 쉼표가 아닌 경우 예외 메세지가 출력되고 애플리케이션이 종료된다.")
        void winning_numbers_invalid_separator_exception_test(String invalidInput) {
            assertSimpleTest(() -> {
                runException("1000", invalidInput);
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @ParameterizedTest
        @ValueSource(strings = {"12345", "1,2,3,4,5", "1,2,3,4,5,6,7"})
        @DisplayName("만약 당첨 번호의 길이가 유효하지 않은 경우 예외 메세지가 출력되고 애플리케이션이 종료된다.")
        void winning_numbers_invalid_input_length_exception_test(String invalidInput) {
            assertSimpleTest(() -> {
                runException("1000", invalidInput);
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @ParameterizedTest
        @ValueSource(strings = {"0,1,2,3,4,5", "1,2,3,4,5,46"})
        @DisplayName("만약 당첨 번호가 1 ~ 45에 포함되지 않은 경우 예외 메세지가 출력되고 애플리케이션이 종료된다.")
        void winning_numbers_invalid_number_range_exception_test(String invalidInput) {
            assertSimpleTest(() -> {
                runException("1000", invalidInput);
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @ParameterizedTest
        @ValueSource(strings = {"0", "46"})
        @DisplayName("만약 보너스 번호가 1 ~ 45에 포함되지 않은 경우 예외 메세지가 출력되고 애플리케이션이 종료된다.")
        void bonus_number_invalid_number_range_exception_test(String invalidInput) {
            assertSimpleTest(() -> {
                runException("1000", "1,2,3,4,5,6", invalidInput);
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @ParameterizedTest
        @ValueSource(strings = {"a", "@", " "})
        @DisplayName("만약 보너스 번호가 숫자가 아닌 경우 예외 메세지가 출력되고 애플리케이션이 종료된다.")
        void bonus_number_invalid_number_format_exception_test(String invalidInput) {
            assertSimpleTest(() -> {
                runException("1000", "1,2,3,4,5,6", invalidInput);
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }
    }
}