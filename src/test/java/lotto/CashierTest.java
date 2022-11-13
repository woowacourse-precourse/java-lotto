package lotto;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CashierTest extends IOTest {
    private  static Cashier cashier;
    public static Scanner scanner;
    @BeforeAll
    static void initAll(){
        cashier = new Cashier();
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
    @DisplayName(",000 입력에 대한 예외 처리가 되는지")
    void validateCommaTest_thousand_IllegalArgumentException(){
        String input = "168219125";
        assertThatThrownBy(()->cashier.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 천원 단위로 입력해주세요");
    }
}
