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
        Buyer buyer = new Buyer();
        String notMultipleOfThousand = "12345";
        String notNumber = "abc123";
        String startWithZero = "05000";
        String smallerThanOneThousand = "800";

        System.setIn(new ByteArrayInputStream(notMultipleOfThousand.getBytes()));
        assertThatThrownBy(() -> buyer.validatePurchaseAmount(UserInterface.readPurchaseAmount()))
                .isInstanceOf(IllegalArgumentException.class);

        System.setIn(new ByteArrayInputStream(notNumber.getBytes()));
        assertThatThrownBy(() -> buyer.validatePurchaseAmount(UserInterface.readPurchaseAmount()))
                .isInstanceOf(IllegalArgumentException.class);

        System.setIn(new ByteArrayInputStream(startWithZero.getBytes()));
        assertThatThrownBy(() -> buyer.validatePurchaseAmount(UserInterface.readPurchaseAmount()))
                .isInstanceOf(IllegalArgumentException.class);

        System.setIn(new ByteArrayInputStream(smallerThanOneThousand.getBytes()));
        assertThatThrownBy(() -> buyer.validatePurchaseAmount(UserInterface.readPurchaseAmount()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액에 따라 올바른 수의 복권을 발행한다.")
    @Test
    void pickLotteryNumbersTest() {
        Buyer buyer = new Buyer();
        String eightThousand = "8000";
        String purchaseAmount;
        List<List<Integer>> lotteryTickets;

        System.setIn(new ByteArrayInputStream(eightThousand.getBytes()));
        purchaseAmount = UserInterface.readPurchaseAmount();
        lotteryTickets = buyer.pickLotteryNumbers(Integer.parseInt(purchaseAmount) / 1000);
        assertEquals(8, lotteryTickets.size());
    }



    @DisplayName("구입 금액에 따라 올바른 수의 복권을 발행한다.")
    @Test
    void sortLotteryNumbersTest() {
        List<List<Integer>> lotteryTicket = new ArrayList<>();
        List<Integer> ticket = new ArrayList<>();
        Buyer buyer = new Buyer();

        ticket.add(4);
        ticket.add(6);
        ticket.add(5);
        ticket.add(2);
        ticket.add(3);
        ticket.add(1);
        lotteryTicket.add(ticket);
        buyer.sortLotteryNumbers(lotteryTicket);
        for (int i = 0; i < lotteryTicket.size(); i++) {
            assertEquals(i + 1, lotteryTicket.get(0).get(i));
        }
    }
}
