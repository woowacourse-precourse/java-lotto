package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class DrawNumber {
    public static List<List<Integer>> lottos = new ArrayList<>();

    public static void generateNumber(int ticketAmount) {
        System.out.println(ticketAmount + GameMessage.PURCHASE_MESSAGE.getMessage());
        for (int count = 0; count < ticketAmount; count++) {
            List<Integer> oneTicketNumber = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(oneTicketNumber);
            lottos.add(oneTicketNumber);
        }
    }

    public static void printNumber(int ticketAmount) {
        for (int count = 0; count < ticketAmount; count++) {
            System.out.println(lottos.get(count));
        }
    }
}
