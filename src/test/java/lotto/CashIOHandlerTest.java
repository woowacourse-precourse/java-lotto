package lotto;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CashIOHandlerTest extends IOTest {
    private  static CashIOHandler cashier;
    @BeforeAll
    static void initAll(){
        cashier = new CashIOHandler();
    }
    @Test
    @DisplayName("사용자의 입력이 제대로 입력되는지")
    void getUserInputTest(){
        systemIn("1124124");
        assertThat(cashier.getUserInput()).isEqualTo("1124124");
    }

    @Test
    @DisplayName(",000 입력에 대한 처리가 되는지")
    void validateInput_comma(){
        String input = "168,219,000";
        String comma = cashier.validateInput(input);
        assertThat(comma).isEqualTo("168219000");
    }

    @Test
    @DisplayName(",000 입력에 대한 예외 처리가 되는지")
    void validateInput_comma_IllegalArgumentException(){
        String input = "168,219,125";
        assertThatThrownBy(()->cashier.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 천원 단위로 입력해주세요");
    }

    @Test
    @DisplayName("000 단위에 대한 검증이 정상 처리되는지")
    void validateInputTest_thousand(){
        String input2 = "168219000";
        String normal = cashier.validateInput(input2);
        assertThat(normal).isEqualTo("168219000");
    }

    @Test
    @DisplayName("000 단위에 대한 예외 처리가 되는지")
    void validateCommaTest_thousand_IllegalArgumentException(){
        String input = "168219125";
        assertThatThrownBy(()->cashier.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 천원 단위로 입력해주세요");
    }

    @Test
    @DisplayName("금액 입력에 대한 로또 갯수가 제대로 나오는지")
    void getLotteryAmountTest(){
        systemIn("125000");
        cashier.setUserCash();
        assertThat(cashier.getLotteryAmount()).isEqualTo(125);
    }
}
