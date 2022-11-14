package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class UserInterface {
    private static final String[] OUTPUT_MESSAGE = {
            "구입금액을 입력해 주세요.",
            "개를 구매했습니다.",
            "당첨 번호를 입력해 주세요."
    };

    public static String readUserInput(Index index) {
        System.out.println(OUTPUT_MESSAGE[index.getIndex()]);
        return (readLine());
    }

    public static void writeLotteryTickets(List<List<Integer>> tickets) {
        System.out.println(tickets.size() + OUTPUT_MESSAGE[Index.PURCHASE_COUNT
                .getIndex()]);
        for (List<Integer> ticket : tickets) {
            System.out.println(ticket.toString());
        }
    }
}
