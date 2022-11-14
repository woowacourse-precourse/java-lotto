package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BuyerTest {

    // 아래에 추가 테스트 작성 가능
    @DisplayName("입력된 구매 금액 배수인 숫자가 아니면 예외가 발생한다.")
    @Test
    void readPurchaseAmountTest() {
        Buyer buyer = new Buyer();
        String input = "12345";
        InputStream in = new ByteArrayInputStream(input.getBytes());

        System.setIn(in);
        assertThatThrownBy(buyer::readPurchaseAmount)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
