package lotto.view;

import lotto.domain.Amounts;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputTest {

    private Input input;

    @Test
    @DisplayName("조건에 맞는 로또 구입 금액을 입력받은 case.")
    void inputPurchasingAmount() {
        String amount = "1000";
        final byte[] buf = String.join("\n", amount).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        assertEquals(input.inputPurchasingAmount().getMoney(),
                new Amounts(Integer.parseInt(amount)).getMoney());
    }

    @Test
    @DisplayName("조건에 맞지 않은 로또 구입 금액을 입력받은 case.")
    void inputWinningNumber() {
        String winningNumber = "1,2,3,4,6,6";       // 중복 숫자가 포함
        byte[] buf = String.join("\n", winningNumber).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        assertThatThrownBy(() -> input.inputWinningNumber())
                .isInstanceOf(IllegalArgumentException.class);

        String winningNumber2 = "1,2,3,4,5";    // 6자리 수가 아닌 경우
        buf = String.join("\n", winningNumber2).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        assertThatThrownBy(() -> input.inputWinningNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

//    @Test
//    void inputBonusNumber() {
//        String winningNumber = "1,2,3,4,5,6";       // 당첨 번호를 생성.
//        byte[] buf = String.join("\n", winningNumber).getBytes();
//        System.setIn(new ByteArrayInputStream(buf));
//        List<Integer> numbers = input.inputWinningNumber();
//
//        buf = String.join("\n", "6").getBytes();    // 당첨 번호와 중복
//        System.setIn(new ByteArrayInputStream(buf));
//
//        assertThatThrownBy(() -> input.inputBonusNumber(numbers))
//                .isInstanceOf(IllegalArgumentException.class);
//
//        buf = String.join("\n", "47").getBytes();    // 잘못된 보너스 번호 입력
//        System.setIn(new ByteArrayInputStream(buf));
//
//        assertThatThrownBy(() -> input.inputBonusNumber(numbers))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
}