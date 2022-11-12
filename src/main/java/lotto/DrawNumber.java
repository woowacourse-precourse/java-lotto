package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Collections;

public class DrawNumber {
    public static List<Lotto> Lottos;

    public static void generateNumber(int ticketAmount) {
        System.out.println(Integer.toString(ticketAmount) + GameMessage.PURCHASE_MESSAGE.getMessage());
        for (int count = 0; count < ticketAmount; count++) {
            List<Integer> oneTicketNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(oneTicketNumber);
            Lotto oneLotto = new Lotto(oneTicketNumber);
            Lottos.add(oneLotto);
        }
    }

    public static void printNumber(int ticketAmount) {
        for (int count = 0; count < ticketAmount; count++) {
            System.out.println(Lottos.get(count));
        }
    }
}
