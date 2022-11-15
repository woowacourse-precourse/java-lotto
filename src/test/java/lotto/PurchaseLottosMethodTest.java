package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.Application.initializeNumberType;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseLottosMethodTest extends NsTest {
    ArrayList<Integer> winningNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

    @DisplayName("구매 금액 입력에 대한 출력 문구 테스트")
    @Test
    void purchaseLottosMethodTest1() {
        initializeNumberType();
        new Lotto(winningNumbers);

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000");
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

    @DisplayName("숫자 외 다른 문자 입력에 대해 예외가 발생한다.")
    @Test
    void purchaseLottosMethodExceptionTest1() {
            assertThatThrownBy(() -> {
                assertSimpleTest(() -> run("*"));
            })
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 숫자 외 다른 문자는 입력이 불가합니다.");
    }

    @DisplayName("1000원 단위가 아닌 구매 금액에 대해 예외가 발생한다.")
    @Test
    void purchaseLottosMethodExceptionTest2() {
        assertThatThrownBy(() -> {
            assertSimpleTest(() -> run("1001"));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 금액을 1000원 단위로 입력해 주세요.");
    }

    @DisplayName("20억을 초과하는 1000의 배수에 대해 예외가 발생한다.")
    @Test
    void purchaseLottosMethodExceptionTest3() {
        assertThatThrownBy(() -> {
            assertSimpleTest(() -> run("2000001000"));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 20억원보다 큰 금액으로 복권을 구매할 수 없습니다.");
    }

    @DisplayName("20억을 초과하는 숫자에 대해 예외가 발생한다.")
    @Test
    void purchaseLottosMethodExceptionTest4() {
        assertThatThrownBy(() -> {
            assertSimpleTest(() -> run("123456789012345678"));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 20억원보다 큰 금액으로 복권을 구매할 수 없습니다.");
    }

    @DisplayName("문자열 길이가 18을 초과하는 입력에 대해 예외가 발생한다.")
    @Test
    void purchaseLottosMethodExceptionTest5() {
        assertThatThrownBy(() -> {
            assertSimpleTest(() -> run("1234567890123456789"));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 20억원보다 큰 금액으로 복권을 구매할 수 없습니다.");
    }

    @DisplayName("구매 금액이 0인 경우 예외가 발생한다.")
    @Test
    void purchaseLottosMethodExceptionTest6() {
        assertThatThrownBy(() -> {
            assertSimpleTest(() -> run("0"));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1000원 이상의 값을 입력해 주세요.");
    }

    @Override
    public void runMain() {
        Application.purchaseLottos();
    }
}