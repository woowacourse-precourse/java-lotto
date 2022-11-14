package lotto.IOTest;

import lotto.IO.CashIOHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CashIOHandlerTest extends IOTest {
    private  static CashIOHandler cashier;
    @BeforeEach
    void initAll(){
        cashier = new CashIOHandler();
    }
    @DisplayName("사용자의 입력이 제대로 입력되는지")
    @Test
    void getUserInputTest(){
        systemIn("1124124");
        assertThat(cashier.getUserInput()).isEqualTo("1124124");
    }

    @DisplayName(",000 입력에 대한 예외 처리가 되는지")
    @Test
    void validateInput_comma_IllegalArgumentException(){
        String input = "168,219,125";
        assertThatThrownBy(()->cashier.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 천원 단위로 입력해주세요");
    }

    @DisplayName("000 단위에 대한 예외 처리가 되는지")
    @Test
    void validateInput_thousand_IllegalArgumentException(){
        String input = "168219125";
        assertThatThrownBy(()->cashier.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 천원 단위로 입력해주세요");
    }

    @DisplayName("금액 입력에 대한 로또 갯수가 제대로 나오는지")
    @Test
    void getLotteryAmountTest(){
        systemIn("125000");
        cashier.setUserCash();
        assertThat(cashier.getLotteryAmount()).isEqualTo(125);
    }
}
