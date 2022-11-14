package lotto.view;

import lotto.domain.Amounts;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.*;

class InputTest {


    @Test
    @DisplayName("조건에 맞는 로또 구입 금액을 입력받은 case.")
    void inputPurchasingAmount() {
        String amount = "1000";
        final byte[] buf = String.join("\n", amount).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        assertEquals(Input.inputPurchasingAmount().getMoney(),
                new Amounts(Integer.parseInt(amount)).getMoney());
    }
}