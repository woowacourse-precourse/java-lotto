package lotto.domain;

import static lotto.Config.WINNING_RANK_AMOUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;

import java.lang.reflect.Method;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ControllerTest {
    private static Controller controller;

    @DisplayName("테스트를 위해 Controller 클래스를 Mocking 처리한다.")
    @BeforeAll
    public static void beforeALl() {
        controller = mock(Controller.class);
    }

    @DisplayName("숫자 형식의 문자열이 아닐 때 예외가 발생한다.")
    @Test
    void testNotNumericString() throws NoSuchMethodException {
        Method checkNumericStringMethod = Controller.class.getDeclaredMethod("checkNumericString", String.class);
        checkNumericStringMethod.setAccessible(true);

        String noNumericString = "1000j";

        assertThatThrownBy(() -> checkNumericStringMethod.invoke(controller, noNumericString)).getCause()
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1,000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void testNotDivisibleThousand() throws NoSuchMethodException {
        Method checkDivisibleThousandMethod = Controller.class.getDeclaredMethod("checkDivisibleThousand", int.class);
        checkDivisibleThousandMethod.setAccessible(true);

        int number = 1001;

        assertThatThrownBy(() -> checkDivisibleThousandMethod.invoke(controller, number)).getCause()
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열 구입 금액을 숫자 형식으로 변환")
    @Test
    void testFormatStringToNumber() throws Exception {
        Method formatStringToNumberMethod = Controller.class.getDeclaredMethod("formatStringToNumber", String.class);
        formatStringToNumberMethod.setAccessible(true);

        String numericString = "1000";

        assertThat(
                formatStringToNumberMethod.invoke(controller, numericString))
                .isEqualTo(1000);
    }

    @DisplayName("당첨 금액을 당첨 등수로 변환한다.")
    @Test
    void testChangeMoneyToRank() throws Exception {
        Method changeMoneyToRankMethod = Controller.class.getDeclaredMethod("changeMoneyToRank", int.class);
        changeMoneyToRankMethod.setAccessible(true);

        int rank = 0;
        int lotto1stMoney = WINNING_RANK_AMOUNT[rank];

        assertThat(
                changeMoneyToRankMethod.invoke(controller, lotto1stMoney))
                .isEqualTo(rank);
    }
}
