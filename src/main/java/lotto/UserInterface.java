package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class UserInterface {
    public static String readUserInput(InformMessage message) {
        System.out.println(message.toString());
        return (readLine());
    }

    public static void writeLotteryTickets(BoughtTicketsDTO boughtTickets) {
        List<Lotto> tickets = boughtTickets.getTickets();
        String format = InformMessage.PURCHASE_COUNT
                .toString();

        System.out.printf(format, tickets.size());
        for (Lotto ticket : tickets) {
            System.out.println(ticket.getSortedString());
        }
    }

    public static void writeResult(WinningCountsDTO winningCounts) {
        int[] counts = winningCounts.getWinningCounts();
        String format = InformMessage.RESULT
                .toString();

        System.out.printf(format, counts[0], counts[1], counts[2], counts[3], counts[4]);
    }

    public static void writeEarningRate(double earningRate) {
        System.out.printf(InformMessage.EARNING_RATE
                .toString(), earningRate);
    }

    public static void writeExceptionMessage(IllegalArgumentException ex) {
        System.out.println(ex.getMessage());
    }
}
