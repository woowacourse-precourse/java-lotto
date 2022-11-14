package Character;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class LotteryTicketMachineTest {

    LotteryTicketingMachine lotteryTicketingMachine = new LotteryTicketingMachine();

    @Test
    void ticketHowManyLottoTest() {
        int moneyInput = 3000;
        int result = 3;

        assertEquals(result,lotteryTicketingMachine.ticketHowManyLotto(moneyInput));
    }

    @Test
    void ticketHowManyLottoErrorCaseTest() {
        int moneyInput = 3100;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            lotteryTicketingMachine.ticketHowManyLotto(moneyInput);
        });
    }

    @Test
    void ticketLottoIfAscendingOrder() {
        try {
            Lotto lotto = lotteryTicketingMachine.ticketLotto();
            Lotto sortedLotto = (Lotto) lotto.clone();
            sortedLotto.sort();
            assertEquals(true,lotto.equals(sortedLotto));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void checkWinningNumberTest() {
        List<Integer> number = List.of(1,2,3,4,5,6);
        List<Integer> winningNumber = List.of(3,6,9,12,15,18);
        Lotto lotto = new Lotto(number);
        int result = 2;

        assertEquals(result,lotteryTicketingMachine.checkWinningNumber(winningNumber,lotto));

    }

}
