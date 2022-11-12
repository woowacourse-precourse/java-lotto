package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Data.UserMoney;
import lotto.handler.InputMoneyHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    InputMoneyHandler inputMoneyHandler = new InputMoneyHandler();

    @DisplayName("사용자의 입력 금액이 User에 저장 되었는지 확인 Test")
    @Test
    void checkUserInputMoney() {
        String inputMoney = "1000";
        UserMoney userMoney = new UserMoney(Integer.parseInt(inputMoney));

        assertThat(Integer.parseInt(inputMoney)).isEqualTo(userMoney.getMoney());
    }

    @DisplayName("사용자의 입력 금액이 숫자가 아닐 때 예외발생 Test")
    @Test
    void checkIsNumber() {
        String inputMoney = "1000a";

        assertThatThrownBy(() -> {
            inputMoneyHandler.checkIsNumber(inputMoney);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자의 입력 금액이 0일 때 예외발생 Test")
    @Test
    void checkIsNonzero() {
        String inputMoney = "0";

        assertThatThrownBy(() -> {
            inputMoneyHandler.checkIsNonzero(inputMoney);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자의 입력 금액이 1000으로 나누어지지 않을 때 예외발생 Test")
    @Test
    void checkIsValidMoney() {
        String inputMoney = "1001";

        assertThatThrownBy(() -> {
            inputMoneyHandler.checkIsValidMoney(inputMoney);
        }).isInstanceOf(IllegalArgumentException.class);
    }

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
}
