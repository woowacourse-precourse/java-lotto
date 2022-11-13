package lotto.view;

import java.util.List;

public class OutputView {

    public static void writeLottoTickets(List<List<String>> tickets){
        System.out.println(tickets.size()+"개를 구매했습니다.");
        for (List<String> ticket : tickets){
            System.out.println(ticket);
        }
        System.out.println();
    }
}
