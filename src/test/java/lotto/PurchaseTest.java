package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.PurchaseService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseTest extends NsTest {
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


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
