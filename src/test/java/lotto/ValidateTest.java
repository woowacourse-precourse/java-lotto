package lotto;

import static org.assertj.core.api.Assertions.*;

import lotto.domain.Validate;
import lotto.view.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ValidateTest {
    Validate test = new Validate();
    private final List<Integer> testcase1 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
    @DisplayName("넣은 돈이 1000원 단위가 아닐 경우")
    @Test
    void not1000Money() {
        long money2 = 1200;
        assertThatThrownBy(() -> test.validMoney(money2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_COAST.getErrorMessage());
    }
    @DisplayName("넣은 돈이 1000원 이하일 경우")
    @Test
    void lessThen1000(){
        long money1 = 200;
        assertThatThrownBy(() -> test.validMoney(money1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LESS_COAST.getErrorMessage());
    }
    @DisplayName("보너스 점수가 1 ~ 45의 번호가 아닐 test")
    @Test
    void validateBonusNumber() {
        String testcase = "0";
        String testcase2 = "123";
        assertThatThrownBy(() -> test.validateBonusNumber(testcase1, testcase))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_NUMBER_RANGE.getErrorMessage());
        assertThatThrownBy(() -> test.validateBonusNumber(testcase1, testcase2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_NUMBER_RANGE.getErrorMessage());
    }
    @DisplayName("보너스 점수가 당첨 번호와 겹칠 경우")
    @Test
    void duplicatedNumberWithWinningNumber(){
        String testcase = "1";
        assertThatThrownBy(() -> test.validateBonusNumber(testcase1, testcase))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.CONTAIN_WINNING_NUMBER.getErrorMessage());
    }
    @DisplayName("보너스 점수가 두개가 들어왔을 경우")
    @Test
    void onlyOneBonusNumber(){
        String testcase = "1,2";
        assertThatThrownBy(() -> test.validateBonusNumber(testcase1, testcase))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_DIGIT.getErrorMessage());
    }
    @DisplayName("당첨 번호가 숫자 이외가 있는 경우")
    @Test
    void validateUserInput() {
        String testcase = "1,2,3,45, 1";
        assertThatThrownBy(() -> test.validateUserInput(testcase))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_DIGIT.getErrorMessage());
    }
    @DisplayName("당첨번호가 1 ~ 45 범위의 번호가 아닌 경우")
    @Test
    void validUserWinningNumber() {
        List<Integer> testcase1 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 48));
        assertThatThrownBy(() -> test.validUserWinningNumber(testcase1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_NUMBER_RANGE.getErrorMessage());
    }
    @DisplayName("당첨번호가 서로 중복일 경우")
    @Test
    void duplicatedNumber(){
        List<Integer> testcase2 = new ArrayList<>(List.of(1, 2, 3, 5, 5, 6));
        assertThatThrownBy(() -> test.validUserWinningNumber(testcase2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.DUPLICATED_NUMBER.getErrorMessage());
    }
    @DisplayName("번호가 1 ~ 45 사이의 번호에 대한 test")
    @Test
    void rangeOfNumber(){
        int number = 46;
        assertThatThrownBy(() -> test.correctNumberRange(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_NUMBER_RANGE.getErrorMessage());
    }
}