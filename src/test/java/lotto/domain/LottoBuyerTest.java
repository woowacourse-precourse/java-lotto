package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoBuyerTest {
    Scanner scanner = new Scanner(System.in);
    @DisplayName("구매 금액 지불 시 1,000원 단위로 지불하지 않은 경우 예외가 발생한다.")
    @Test
    void 구매_금액_지불_단위_예외() {
        String input = "10500";

        InputStream userInput = userInput(input);
        System.setIn(userInput);
        scanner = new Scanner(System.in);

        assertThatThrownBy(() -> LottoBuyer.getInstance.getPay())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구매 금액은 1,000 단위로만 입력 가능합니다.");
    }

    @DisplayName("구매 금액이 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void 구매_금액_숫자가_아닐_경우_예외() {
        String input = "12a00";
        InputStream userInput = userInput(input);
        System.setIn(userInput);
        scanner = new Scanner(System.in);

        assertThatThrownBy(() -> LottoBuyer.getInstance.getPay())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력 가능합니다.");
    }

    private static InputStream userInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
