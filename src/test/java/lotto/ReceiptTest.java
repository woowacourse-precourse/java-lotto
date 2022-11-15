package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class ReceiptTest {
    @DisplayName("금액이 음수로 주어졌을 때 Receipt 생성 기능 테스트")
    @Test
    void createReceiptByNegative() {
        Assertions.assertThatThrownBy(() -> new Receipt(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 0으로 주어졌을 때 Receipt 생성 기능 테스트")
    @Test
    void createReceiptByZero() {
        Assertions.assertThatThrownBy(() -> new Receipt(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 1000으로 나누어지지 않을 때 Receipt 생성 기능 테스트")
    @Test
    void createReceiptByNotDividedValue() {
        Assertions.assertThatThrownBy(() -> new Receipt(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 기능 테스트")
    @Test
    void buyTest() {
        Receipt receipt = new Receipt(2000);
        List<Lotto> lottos = receipt.buy();
        Assertions.assertThat(lottos.size()).isEqualTo(2);
    }

    @DisplayName("구매 수량 출력 기능 테스트")
    @Test
    void printReceiptTest() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Receipt receipt = new Receipt(2000);
        receipt.printReceipt();

        Assertions.assertThat(output.toString()).isEqualTo("2개를 구매했습니다.\n");
    }
}
