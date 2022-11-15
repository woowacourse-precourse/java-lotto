package lotto.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidationTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("로또 구입 금액이 1000의 배수가 아니면 에러가 발생한다.")
    @Test
    void createPurchaseMoneyNotDivision1000() {
        // given
        String purchaseMoney = "1111";

        // when + then
        assertThatThrownBy(() -> Validation.validatePurchaseMoney(purchaseMoney))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);

    }

    @DisplayName("로또 그입 금액이 숫자로 구성되어있지 않으면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"abc", "ㄱㄴㄷ", "12.", "!*%"})
    void createPurchaseMoneyOtherThanNum(String purchaseMoney) {
        assertThatThrownBy(() -> Validation.validatePurchaseMoneyConsistOfNum(purchaseMoney))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("로또 구입 금액이 1000보다 작으면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"999", "900", "0", "200", "-1"})
    void createPurchaseMoneyLessThan1000(String purchaseMoney) {
        assertThatThrownBy(() -> Validation.validatePurchaseMoneyGreaterThan1000(purchaseMoney))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("당첨 번호 입력에 숫자와 , 이외의 값이 들어가면 에러가 발생한다. 단 ,는 꼭 포함해야한다.")
    @ParameterizedTest
    @ValueSource(strings = {"111", "1.425.", "asb", "ㄱㄴㄷ", "!@1"})
    void createWinningNumberByOtherThanNumAndComma(String winningNumber) {
        assertThatThrownBy(() -> Validation.validateWinningNumberContainCommaAndNum(winningNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName(",로 분리된 당첨 번호가 숫자 이외의 값이 있으면 에러가 발생합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,,,2,3", "1,ㄱ,2,ㄴ", "!,@,#,$", "a,b,c", "~,1,2,3", "1ㄱ,2ㄴ,3"})
    void createWinningNumberWithContinuousCommaOrOther(String winningNumber) {
        assertThatThrownBy(() -> Validation.validateWinningNumberSplitCommaConsistOfNum(winningNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("당첨 번호 입력에 ,가 처음과 끝에 들어가면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {",1,2,3,4,5,6", "1,2,3,4,5,6,"})
    void createWinningNumberByStartWithOrEndWithComma(String winningNumber) {
        assertThatThrownBy(() -> Validation.validateWinningNumberStartOrEndWithComma(winningNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("보너스 번호 입력에 숫자가 아니면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"ㄱㄶ","1,ㅇ","asb","!@G"})
    void createBonusNumberByOtherThanNum(String bonusNumber) {
        assertThatThrownBy(() -> Validation.validateBonusNumberConsistOfNum(bonusNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }
}