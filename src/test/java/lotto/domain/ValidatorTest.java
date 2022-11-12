package lotto.domain;

import static lotto.domain.Validator.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Nested
    class Purchase{
        @Test
        @DisplayName("구입 금액에 영어가 들어오면 예외가 발생한다.")
        void inputPurchaseEnglish() {
            assertThatThrownBy(() -> purchase("q"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }

        @Test
        @DisplayName("구입 금액에 한글이 들어오면 예외가 발생한다.")
        void inputPurchaseKorean() {
            assertThatThrownBy(() -> purchase("가나다라"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }

        @Test
        @DisplayName("구입 금액에 특수문자가 들어오면 예외가 발생한다.")
        void inputPurchaseEscape() {
            assertThatThrownBy(() -> purchase("@"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }

        @Test
        @DisplayName("구입 금액이 천원으로 나누어 떨어지지 않으면 예외가 발생한다.")
        void inputPurchaseLessThan() {
            assertThatThrownBy(() -> purchase("999"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }
    }

    @Nested
    class WinningNumber{
        @Test
        @DisplayName("당첨 번호가 쉼표로 구분되지 않는 경우 예외가 발생한다.")
        void winningNumberNotContainComma(){
            assertThatThrownBy(() -> winningNumbers("1 2 3 4 5 6"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }

        @Test
        @DisplayName("당첨 번호가 숫자 이외의 문자가 포함된 경우 예외가 발생한다.")
        void winningNumberContainNotNumber(){
            assertThatThrownBy(() -> winningNumbers("1,2,3,4,5,@"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }

        @Test
        @DisplayName("당첨 번호가 중복된 숫자가 포함된 경우 예외가 발생한다.")
        void winningNumberContainDuplicationNumber(){
            assertThatThrownBy(() -> winningNumbers("1,2,3,4,5,1"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }

        @Test
        @DisplayName("당첨 번호가 1보다 작을 경우 예외가 발생한다.")
        void winningNumberLessThanOne(){
            assertThatThrownBy(() -> winningNumbers("1,2,3,4,5,-1"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }

        @Test
        @DisplayName("당첨 번호가 45보다 클 경우 예외가 발생한다.")
        void winningNumberGreaterThanFortyFive(){
            assertThatThrownBy(() -> winningNumbers("1,2,3,4,5,46"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }

        @Test
        @DisplayName("당첨 번호의 개수가 6개보다 많을 경우 예외가 발생한다.")
        void winningNumberCountGreaterThanSix(){
            assertThatThrownBy(() -> winningNumbers("1,2,3,4,5,7,6"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }

        @Test
        @DisplayName("당첨 번호의 개수가 6개보다 적을 경우 예외가 발생한다.")
        void winningNumberCountLessThanSix(){
            assertThatThrownBy(() -> winningNumbers("1,2,3,4,5"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }
    }

    @Nested
    class BonusNumber{
        @Test
        @DisplayName("보너스 번호가 숫자 이외의 값이 올 경우 예외가 발생한다.")
        void BonusNumberNotNumber(){
            assertThatThrownBy(() -> bonusNumber("q"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }
        
        @Test
        @DisplayName("보너스 번호가 1보다 작을 경우 예외가 발생한다.")
        void BonusNumberLessThanOne(){
            assertThatThrownBy(() -> bonusNumber("-1"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }

        @Test
        @DisplayName("보너스 번호가 45보다 클 경우 예외가 발생한다.")
        void BonusNumberGreaterThanFortyFive(){
            assertThatThrownBy(() -> bonusNumber("46"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }

        @Test
        @DisplayName("보너스 번호가 당첨 번호에 존재한다면 예외가 발생한다.")
        void BonusNumberAlreadyExistWinningNumber(){
            assertThatThrownBy(() -> checkDuplicate(List.of(1,2,3,4,5,6),5))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }
    }
}