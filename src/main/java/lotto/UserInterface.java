package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class UserInterface {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_COUNT_MESSAGE = "개를 구매했습니다.";


    public static String readPurchaseAmount() {
        String purchaseAmount;

        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        purchaseAmount = readLine();
        return (purchaseAmount);
    }

    public static void writeLotteryTickets(List<List<Integer>> tickets) {
        System.out.println(tickets.size() + PURCHASE_COUNT_MESSAGE);
        for (List<Integer> ticket : tickets) {
            System.out.println(ticket.toString());
        }
    }
}
