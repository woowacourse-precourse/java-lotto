package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.PurchaseService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseTest {

    @DisplayName("구매 금액이 숫자가 아닌 경우 에러 출력 테스트")
    @Test
    void 구매금액_숫자_아닌_경우_에러_테스트(){
        String input="숫자아님";
        PurchaseService purchaseService = new PurchaseService();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> purchaseService.parsePurchaseInput(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("구매 금액이 음수인 경우 에러 출력 테스트")
    @Test
    void 구매금액_음수_에러_테스트(){
        String input = "-1";
        PurchaseService purchaseService = new PurchaseService();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> purchaseService.parsePurchaseInput(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @DisplayName("구매 금액이 1000의 배수가 아닌 경우 에러 출력 테스트")
    @Test
    void 구매금액_1000_배수_아닌_경우_에러_테스트(){
        String input = "2400";
        PurchaseService purchaseService = new PurchaseService();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> purchaseService.parsePurchaseInput(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("정상 구매 테스트")
    @Test
    void 정상_구매_테스트(){
        String input = "5000";
        PurchaseService purchaseService = new PurchaseService();
        purchaseService.parsePurchaseInput(input);
        assertEquals(5, purchaseService.getPurchaseAmount());
    }

}
