package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("구매 금액을 잘못 입력한 경우에는 예외가 발생한다.")
    @Test
    void enterPurchaseMoneyByInputFault() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("08000"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[Error] 구매 금액을 잘못 입력 하셨습니다.");
        });

        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1abc"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[Error] 구매 금액을 잘못 입력 하셨습니다.");
        });
    }

    @DisplayName("구매 금액이 천 원으로 나누어 떨어지지 않는 경우에는 예외가 발생한다.")
    @Test
    void enterPurchaseMoneyByNotDivide() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("9999"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[Error] 구매 금액이 천 원으로 나누어 떨어지지 않는 금액입니다.");
        });
    }

    @DisplayName("로또 번호를 쉼표로 구분할 수 없는 경우에는 예외가 발생한다")
    @Test
    void enterLottoByNotIdentify(){
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("8000", "1.2.3.4.5.6"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[Error] 당첨 번호가 구별되지 않습니다.");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
