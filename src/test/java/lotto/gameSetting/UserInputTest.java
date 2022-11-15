package lotto.gameSetting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserInputTest {
    private UserInput inputTest;

    @BeforeEach
    void setUp() {
        inputTest = new UserInput();
    }
    
    @DisplayName("로또의 구입금액이 1,000원 단위로 떨어지지 않으면 예외 발생")
    @Test
    void thousandMoneyTest() {
        assertThatThrownBy(() -> inputTest.moneyPriceCheck("1050"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1,000원 단위");
    }

    @DisplayName("당첨 번호가 숫자가 아니면 예외 발생")
    @Test
    void winningNumberNumber() {
        final String[] test = {"a","1","2","3","4","5"};

        assertThatThrownBy(() -> inputTest.winningNumberNumberCheck(test))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를");
    }

    @DisplayName("보너스 번호가 숫자가 아니면 에외 발생")
    @Test
    void bonusNumberNumber() {
        assertThatThrownBy(() -> inputTest.bonusNumberNumberCheck("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를");
    }
    
    @DisplayName("보너스 번호가 1~45 이내의 숫자가 아니면 에외 발생")
    @Test
    void bonusNumberRange() {
        assertThatThrownBy(() -> inputTest.bonusNumberRangeCheck("46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1부터 45");
    }
    
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 에외 발생")
    @Test
    void bonusNumberOverlap() {
        final String[] test = {"1", "2", "3", "4", "5", "6"};

        assertThatThrownBy(() -> inputTest.bonusNumberOverlapCheck("6",test))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }
}
