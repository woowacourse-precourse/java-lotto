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
    @DisplayName("1000원 단위 인지 test")
    @Test
    void validMoney() {
        long money1 = 200;
        long money2 = 1200;
        assertThatThrownBy(() -> test.validMoney(money1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LESS_COAST.getErrorMessage());
        assertThatThrownBy(() -> test.validMoney(money2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_COAST.getErrorMessage());
    }
    @DisplayName("당첨 번호가 유효한지에 대한 test")
    @Test
    void validateUserInput() {
        String testcase = "1,2,3,45, 1";
        assertThatThrownBy(() -> test.validateUserInput(testcase))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_DIGIT.getErrorMessage());
    }
    @DisplayName("보너스 점수 유효성에 대한 test")
    @Test
    void validateBonusNumber() {
        String testcase = "1";
        String testcase2 = "123";
        List<Integer> testcase1 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> test.validateBonusNumber(testcase1, testcase))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.CONTAIN_WINNING_NUMBER.getErrorMessage());
        assertThatThrownBy(() -> test.validateBonusNumber(testcase1, testcase2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_NUMBER_RANGE.getErrorMessage());
    }
    @DisplayName("당첨번호의 유효성에 대한 test")
    @Test
    void validUserWinningNumber() {
        List<Integer> testcase1 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 48));
        List<Integer> testcase2 = new ArrayList<>(List.of(1, 2, 3, 5, 5, 6));
        assertThatThrownBy(() -> test.validUserWinningNumber(testcase1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_NUMBER_RANGE.getErrorMessage());
        assertThatThrownBy(() -> test.validUserWinningNumber(testcase2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.DUPLICATED_NUMBER.getErrorMessage());
    }
    @DisplayName("1 ~ 45 사이의 번호에 대한 test")
    @Test
    void rangeOfNumber(){
        int number = 46;
        assertThatThrownBy(() -> test.correctNumberRange(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_NUMBER_RANGE.getErrorMessage());
    }
}