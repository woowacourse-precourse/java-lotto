package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class BuyerTest {

    Buyer buyer = new Buyer();

    @DisplayName("로또 구매 정상 시나리오")
    @Test
    void testReadyForBuyLotto() {
        try (MockedStatic<Console> consoleMockedStatic = mockStatic(Console.class)) {
            String testMoney = "8000";
            when(Console.readLine()).thenReturn(testMoney);

            buyer.readyForBuyLotto();

            assertThat(buyer.getMoney()).isEqualTo(Long.valueOf(testMoney));
        }
    }

    @DisplayName("로또 구매시 금액이 아닌 값이 입력될 시 예외처리")
    @Test
    void inputMoneyByIllegalValue() {
        try (MockedStatic<Console> consoleMockedStatic = mockStatic(Console.class)) {
            String testMoney = "This is not Money";
            when(Console.readLine()).thenReturn(testMoney);

            assertThatThrownBy(() -> buyer.readyForBuyLotto()).hasMessageContaining("[ERROR]");
        }
    }

    @DisplayName("로또 구매시 금액이 1000원 단위가 아닌 값이 입력될 시 예외처리")
    @Test
    void inputMoneyByNotThousandUnits() {
        try (MockedStatic<Console> consoleMockedStatic = mockStatic(Console.class)) {
            String testMoney = "900";
            when(Console.readLine()).thenReturn(testMoney);

            assertThatThrownBy(() -> buyer.readyForBuyLotto()).hasMessageContaining("[ERROR]");
        }
    }

}
