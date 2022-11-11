package lotto.util;

import lotto.common.InputErrors;
import lotto.ui.dto.BonusNumber;
import lotto.ui.dto.LottoPurchasedAmount;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName(value = "보너스 번호 입력 검증 테스트")
class BonusNumberValidatorTest {

    //FIXME: 반복되는 메서드, 필드가 존재함
    private static final String ERROR_PREFIX = "[ERROR]";
    private final Validator validator = new BonusNumberValidator();

    @Test
    public void 보너스_번호는_숫자만_가능하다() {
        String userInput = "1ab";

        String containedMessage = InputErrors.BONUS_NUMBER_NOT_NUMBER.getMessage();
        assertIllegalArgumentException(userInput, containedMessage);
    }

    @Test
    public void 보너스_번호는_1과_45사이의_숫자이다() {
        String userInput = "46";

        String containedMessage = InputErrors.BONUS_NUMBER_OUT_OF_RANGE.getMessage();
        assertIllegalArgumentException(userInput, containedMessage);
    }

    private void assertIllegalArgumentException(String userInput, String containedMessage) {
        Assertions.assertThatThrownBy(() -> generateBonusNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX)
                .hasMessageContaining(containedMessage);
    }

    private void generateBonusNumber(String userInput) {
        new BonusNumber(userInput, validator);
    }


}