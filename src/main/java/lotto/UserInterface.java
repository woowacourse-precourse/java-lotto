package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class UserInterface {
    public static String readUserInput(InformMessage message) {
        System.out.println(message.toString());
        return (readLine());
    }

    public static void writeLotteryTickets(List<List<Integer>> tickets) {
        System.out.println(tickets.size() + InformMessage.WINNING_NUMBER
                .toString());
        for (List<Integer> ticket : tickets) {
            System.out.println(ticket.toString());
        }
    }
}
