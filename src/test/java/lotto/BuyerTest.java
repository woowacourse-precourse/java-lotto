package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;


public class BuyerTest {

    // 아래에 추가 테스트 작성 가능
    @DisplayName("입력된 구매 금액 배수인 숫자가 아니면 예외가 발생한다.")
    @Test
    void readPurchaseAmountTest() {
        String notMultipleOfThousand = "12345";
        String notNumber = "abc123";
        String startWithZero = "05000";
        String smallerThanOneThousand = "800";

        System.setIn(new ByteArrayInputStream(notMultipleOfThousand.getBytes()));
        assertThatThrownBy(() -> new Buyer(UserInterface.readUserInput(
                InformMessage.PURCHASE_AMOUNT))).isInstanceOf(IllegalArgumentException.class);

        System.setIn(new ByteArrayInputStream(notNumber.getBytes()));
        assertThatThrownBy(() -> new Buyer(UserInterface.readUserInput(
                InformMessage.PURCHASE_AMOUNT))).isInstanceOf(IllegalArgumentException.class);

        System.setIn(new ByteArrayInputStream(startWithZero.getBytes()));
        assertThatThrownBy(() -> new Buyer(UserInterface.readUserInput(
                InformMessage.PURCHASE_AMOUNT))).isInstanceOf(IllegalArgumentException.class);

        System.setIn(new ByteArrayInputStream(smallerThanOneThousand.getBytes()));
        assertThatThrownBy(() -> new Buyer(UserInterface.readUserInput(
                InformMessage.PURCHASE_AMOUNT))).isInstanceOf(IllegalArgumentException.class);
    }
}
