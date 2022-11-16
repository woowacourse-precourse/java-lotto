package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.util.ParserUtil;
import lotto.util.ValidationUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class ParserUtilTest {

    @DisplayName("로또 구입 금액 입력값 적정성 테스트")
    @Test
    void validatePurchasingAmount() {
        String input1 = "";
        String input2 = "abcd";
        String input3 = "-1000";
        String input4 = "1500";

        assertThatThrownBy(() -> {
            ParserUtil.parsePurchaseAmountInput(input1);})
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            ParserUtil.parsePurchaseAmountInput(input2);})
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            ParserUtil.parsePurchaseAmountInput(input3);})
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            ParserUtil.parsePurchaseAmountInput(input4);})
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력값 적정성 테스트")
    @Test

    void validateWinningNumber() {

        String input1 = "";
        String input2 = "a,b,c,d,e,f";
        String input3 = ",1,2,3,4,5,6";
        String input4 = "1,2,3,4,5,6,";
        String input5 = "1 ,2, 3, 4, 5, 6";
        String input6 = "1,,2,3,4,5,6";
        String input7 = "1,,2,,,3,,,4,5,,,,6";

        assertThatThrownBy( () -> {
            ParserUtil.parseWinningNumbersInput(input1);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy( () -> {
            ParserUtil.parseWinningNumbersInput(input2);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy( () -> {
            ParserUtil.parseWinningNumbersInput(input3);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy( () -> {
            ParserUtil.parseWinningNumbersInput(input4);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy( () -> {
            ParserUtil.parseWinningNumbersInput(input5);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy( () -> {
            ParserUtil.parseWinningNumbersInput(input6);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy( () -> {
            ParserUtil.parseWinningNumbersInput(input7);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 넘버 입력값 적정성 테스트")
    @Test

    void validateBonusNumber() {
        String input1 = "";
        String input2 = "a";
        String input3 = "-1";
        String input4 = "46";

        assertThatThrownBy(() ->{
            ParserUtil.parseBonusNumberInput(input1);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() ->{
            ParserUtil.parseBonusNumberInput(input2);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() ->{
            ParserUtil.parseBonusNumberInput(input3);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() ->{
            ParserUtil.parseBonusNumberInput(input4);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}