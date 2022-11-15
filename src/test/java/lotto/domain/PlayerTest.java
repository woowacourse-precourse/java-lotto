package lotto.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.constant.MessageConstants.*;


import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사용자 입력 유효성 검사 테스트")
class PlayerTest extends NsTest {
    private final Player player = new Player();

    @DisplayName("입력한 금액만큼 로또가 생성되는지 확인한다.")
    @Test
    void generateLottoByPurchasedAmount() {
        player.purchaseCost = 5000;
        player.purchaseLotto();

        assertThat(player.getLottos()).hasSize(5);
    }

    @Nested
    @DisplayName("구입금액 유효성 검사 테스트")
    class PlayerPurchaseInputTest {
        @DisplayName("구입 금액이 숫자가 아니면 예외가 발생한다.")
        @Test
        void purchaseByNonNumeric() {
            assertSimpleTest(() -> {
                runException("asd123");
                assertThat(output()).contains(ERROR + WRONG_FORMAT_MESSAGE);
            });
        }

        @DisplayName("구입 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
        @Test
        void purchaseWithChange() {
            assertSimpleTest(() -> {
                runException("1234");
                assertThat(output()).contains(ERROR + WRONG_PURCHASE_COST_MESSAGE);
            });
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
