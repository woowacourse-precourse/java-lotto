package lotto.util;

import lotto.common.InputErrors;
import lotto.ui.dto.LottoPurchasedAmount;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName(value = "로또 구입 금액 입력 검증 테스트")
class LottoPurchasedAmountValidatorTest {

    private static final String ERROR_PREFIX = "[ERROR]";
    private final Validator validator = new LottoPurchasedAmountValidator();

    @Test
    public void 빈_값은_입력_될_수_없다() {
        String userInput = "";

        String containedMessage = InputErrors.BLANK.getMessage();
        assertIllegalArgumentException(userInput, containedMessage);
    }

    @Test
    public void 구입_금액은_숫자만_가능하다() {
        String userInput = "1000원";

        String containedMessage = InputErrors.AMOUNT_NOT_NUMBER.getMessage();
        assertIllegalArgumentException(userInput, containedMessage);
    }

    @Test
    public void 구입_금액은_구분자_없는_숫자만_가능하다() {
        String userInput = "1,000";

        String containedMessage = InputErrors.AMOUNT_NOT_NUMBER.getMessage();
        assertIllegalArgumentException(userInput, containedMessage);
    }

    @Test
    public void 구입_금액은_한장의_금액보다_크거나_같아야_한다() {
        String userInput = "300";

        String containedMessage = InputErrors.AMOUNT_UNDER_MINIMUM.getMessage();
        assertIllegalArgumentException(userInput, containedMessage);
    }

    @Test
    public void 구입_금액은_최대_한도를_넘을_수_없다() {
        String userInput = "1000000";

        String containedMessage = InputErrors.AMOUNT_OVER_LIMIT.getMessage();
        assertIllegalArgumentException(userInput, containedMessage);
    }

    @Test
    public void 구입_금액은_한장의_가격으로_나누어_떨어져야_한다() {
        String userInput = "5100";

        String containedMessage = InputErrors.AMOUNT_NOT_DIVIDABLE.getMessage();
        assertIllegalArgumentException(userInput, containedMessage);
    }

    private void assertIllegalArgumentException(String userInput, String containedMessage) {
        Assertions.assertThatThrownBy(() -> generateLottoPurchasedAmount(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX)
                .hasMessageContaining(containedMessage);
    }

    private void generateLottoPurchasedAmount(String userInput) {
        new LottoPurchasedAmount(userInput, validator);
    }
}