package lotto.view;

import lotto.domain.Amounts;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
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

    @Test
    @DisplayName("조건에 맞지 않은 로또 구입 금액을 입력받은 case.")
    void inputWinningNumber() {
        String winningNumber = "1,2,3,4,6,6";       // 중복 숫자가 포함
        byte[] buf = String.join("\n", winningNumber).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        assertThatThrownBy(() -> Input.inputWinningNumber())
                .isInstanceOf(IllegalArgumentException.class);

        String winningNumber2 = "1,2,3,4,5";    // 6자리 수가 아닌 경우
        buf = String.join("\n", winningNumber2).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        assertThatThrownBy(() -> Input.inputWinningNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }
}