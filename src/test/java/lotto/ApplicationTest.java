package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import static lotto.Application.purchasedLottos;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("요구 사항에 주어진 출력 양식을 따라 출력한다.")
    @Test
    void 정상_작동_테스트1() {
        purchasedLottos = new ArrayList<>();
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

    @DisplayName("n개의 당첨번호가 주어지면 당첨금도 n배가 된다.")
    @Test
    void 정상_작동_테스트2() {
        purchasedLottos = new ArrayList<>();
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("10000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "10개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]",
                            "[1, 2, 3, 4, 5, 6]",
                            "[1, 2, 3, 4, 5, 6]",
                            "[1, 2, 3, 4, 5, 6]",
                            "[1, 2, 3, 4, 5, 6]",
                            "[1, 2, 3, 4, 5, 6]",
                            "[1, 2, 3, 4, 5, 6]",
                            "[1, 2, 3, 4, 5, 6]",
                            "[1, 2, 3, 4, 5, 6]",
                            "[1, 2, 3, 4, 5, 6]",
                            "[1, 2, 3, 4, 5, 6]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 10개",
                            "총 수익률은 200000000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @DisplayName("입력 금액에 숫자 외 다른 입력이 주어지면 예외가 발생한다.")
    @Test
    void 입력_금액_테스트1() {
        purchasedLottos = new ArrayList<>();
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("입력 금액이 1000의 배수가 아닌 경우 예외가 발생한다.")
    @Test
    void 입력_금액_테스트2() {
        purchasedLottos = new ArrayList<>();
        assertSimpleTest(() -> {
            runException("10001");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("입력 금액이 0인 경우 예외가 발생한다.")
    @Test
    void 입력_금액_테스트3() {
        purchasedLottos = new ArrayList<>();
        assertSimpleTest(() -> {
            runException("0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("쉼표만으로 구분되지 않은 당첨 번호는 예외 처리한다.")
    @Test
    void 당첨_번호_양식_예외_테스트() {
        purchasedLottos = new ArrayList<>();
        assertSimpleTest(() -> {
            runException("10000", "1, 2, 3, 4, 5, 6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호 46: 1이상 45이하 자연수가 아닌 당첨 번호는 예외 처리한다.")
    @Test
    void 당첨_번호_예외_범위_테스트1() {
        purchasedLottos = new ArrayList<>();
        assertSimpleTest(() -> {
            runException("10000", "1, 2, 3, 4, 5, 46");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호 0: 1이상 45이하 자연수가 아닌 당첨 번호는 예외 처리한다.")
    @Test
    void 당첨_번호_예외_범위_테스트2() {
        purchasedLottos = new ArrayList<>();
        assertSimpleTest(() -> {
            runException("10000", "0, 2, 3, 4, 5, 6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("숫자가 아닌 보너스 번호를 입력하면 예외가 발생한다.")
    @Test
    void 보너스_번호_양식_예외_테스트1() {
        purchasedLottos = new ArrayList<>();
        assertSimpleTest(() -> {
            runException("10000", "1,2,3,4,5,6", "neppiness");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("1이상 45이하 자연수가 아닌 보너스 번호는 예외 처리한다.")
    @Test
    void 보너스_번호_예외_테스트1() {
        purchasedLottos = new ArrayList<>();
        assertSimpleTest(() -> {
            runException("10000", "1,2,3,4,5,6", "46");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호와 중복되는 보너스 번호는 예외 처리한다.")
    @Test
    void 보너스_번호_예외_테스트2() {
        purchasedLottos = new ArrayList<>();
        assertSimpleTest(() -> {
            runException("10000", "1,2,3,4,5,6", "6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}