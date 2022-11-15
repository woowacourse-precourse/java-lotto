package lotto;

import lotto.domain.PurchaseAmount;
import lotto.domain.ResultMessage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.ResultMessage.increaseCountResult;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PurchaseAmountTest {
    @AfterEach
    public void init() {
        ResultMessage.initResultMessage();
    }

    @DisplayName("예외 테스트: 입력된 금액으로 빈 문자열이 들어왔을 경우")
    @Test
    void purchaseAmountNullTest() {
        String input = "";

        assertThatThrownBy(() -> new PurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외 테스트입력된 금액이 숫자로만 이루어지지 않았을 경우")
    @Test
    void purchaseAmountNumericTest() {
        String input = "12000원";

        assertThatThrownBy(() -> new PurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외 테스트: 입력된 금액이 1000으로 나누어 떨어지지 않는 경우")
    @Test
    void purchaseAmountRemainderTest() {
        String input = "12005";

        assertThatThrownBy(() -> new PurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외 테스트: 입력된 금액이 1000원 이하일 경우")
    @Test
    void purchaseAmountRangeTest() {
        String input = "500";

        assertThatThrownBy(() -> new PurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("기능 테스트: 입력된 금액을 통해 구매 로또 수 구하기")
    @Test
    void gerNumberOfLottoTest() {
        PurchaseAmount purchaseAmount = new PurchaseAmount("8000");
        int lottoNum = purchaseAmount.getLottoNum();

        assertEquals(8, lottoNum);
    }

    @DisplayName("기능 테스트: 당첨금과 구매 금액을 이용해서 수익률 구하기")
    @Test
    void calculateEarningsRateTest() {
        PurchaseAmount purchaseAmount = new PurchaseAmount("8000");

        int countResult = 3;
        boolean bonusNum = false;
        increaseCountResult(countResult, bonusNum);

        String actual = purchaseAmount.calculateEarningsRate();

        assertEquals("62.5%", actual);
    }
}
