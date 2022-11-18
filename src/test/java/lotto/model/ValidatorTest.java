package lotto.model;

import static lotto.model.Validator.validateBonusNumber;
import static lotto.model.Validator.validateDuplication;
import static lotto.model.Validator.validatePurchase;
import static lotto.model.Validator.validateWinningNumbers;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    private static final String ERROR_MESSAGE = "[ERROR]";


    @DisplayName("구입 금액에 천 단위의 양의 정수가 아닐 경우 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"q", "가나다라", "@", "100j","999"})
    void inputPurchaseNotNumberUnitThousand(String purchase) {
        assertThatThrownBy(() -> validatePurchase(purchase))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @ParameterizedTest
    @DisplayName("당첨 번호가 중복되지 않는 1부터 45까지의 6개의 수가 아니면 에러가 발생한다.")
    @ValueSource(strings = {"1 2 3 4 5 6", "1,2,3,4,5,@", "1,2,3,4,5,1", "1,2,3,4,5,-1", "1,2,3,4,5,46",
            "1,2,3,4,5,7,6", "1,2,3,4,5"})
    void winningNumbersDuplicationOrOverOutRange(String winningNumbers) {
        assertThatThrownBy(() -> validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @ParameterizedTest
    @DisplayName("보너스 번호가 46보다 작은 양의 정수가 아닐 경우 에러가 발생한다.")
    @ValueSource(strings = {"q", "-1","46"})
    void bonusNumberNotNumberLessThanFortySix(String bonusNumber){
        assertThatThrownBy(() -> validateBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
        @Test
        @DisplayName("보너스 번호가 당첨 번호에 존재한다면 예외가 발생한다.")
        void BonusNumberAlreadyExistWinningNumber() {
            assertThatThrownBy(() -> validateDuplication(List.of(1, 2, 3, 4, 5, 6), 5))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }
}