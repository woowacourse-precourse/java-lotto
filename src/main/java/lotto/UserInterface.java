package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class UserInterface {
    private enum Output {
        PURCHASE_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
        PURCHASE_COUNT_MESSAGE("개를 구매했습니다.");

        private final String MESSAGE;

        Output(final String message) {
            this.MESSAGE = message;
        }
        @Override
        public String toString() {
            return (this.MESSAGE);
        }
    }

    public static String readPurchaseAmount() {
        String purchaseAmount;

        System.out.println(Output.PURCHASE_AMOUNT_MESSAGE);
        purchaseAmount = readLine();
        return (purchaseAmount);
    }

    public static void writeLotteryTickets(List<List<Integer>> tickets) {
        System.out.println(tickets.size() + Output.PURCHASE_COUNT_MESSAGE
                .toString());
        for (List<Integer> ticket : tickets) {
            System.out.println(ticket.toString());
        }
    }
}
