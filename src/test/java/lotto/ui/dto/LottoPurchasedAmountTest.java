package lotto.ui.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName(value = "로또 구입 금액 입력 검증 테스트")
class LottoPurchasedAmountTest {

    private static final String ERROR_PREFIX = "[ERROR]";

    @Test
    public void 구입_금액은__숫자만_가능하다() {
        String userInput = "1000원";

        String containedMessage = "";
        assertIllegalArgumentException(userInput, containedMessage);
    }

    @Test
    public void 구입_금액은_구분자_없는_숫자만_가능하다() {
        String userInput = "1,000";

        String containedMessage = "";
        assertIllegalArgumentException(userInput, containedMessage);
    }

    @Test
    public void 구입_금액은_한장의_금액보다_크거나_같아야_한다() {
        String userInput = "300";

        String containedMessage = "";
        assertIllegalArgumentException(userInput, containedMessage);
    }

    @Test
    public void 구입_금액은_최대_한도를_넘을_수_없다() {
        String userInput = "1000000";
        assertIllegalArgumentException(userInput, "");
    }

    @Test
    public void 구입_금액은_한장의_가격으로_나누어_떨어져야_한다() {
        String userInput = "5100";
        assertIllegalArgumentException(userInput, "");
    }

    private void assertIllegalArgumentException(String userInput, String containedMessage) {
        Assertions.assertThatThrownBy(() -> getLottoPurchasedAmount(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX)
                .hasMessageContaining(containedMessage);
    }

    private void getLottoPurchasedAmount(String userInput) {
        new LottoPurchasedAmount(userInput);
    }
}