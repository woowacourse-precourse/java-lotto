package view;

import lotto.Lotto;
import lotto.LottoTickets;

import java.util.Comparator;
import java.util.List;

public class Output {
    private static final String OUTPUT_TICKET_COUNT = "개를 구매했습니다.";
    public static void outputTicketCount(int count) {
        System.out.println(count + OUTPUT_TICKET_COUNT);
    }

    public static void outputTicket(LottoTickets lottoTickets) {
        for (Lotto lotto : lottoTickets.getLotto()) {
            System.out.println(lotto.getNumbers());
        }
    }
    public static void outputException(Exception exception) {
        System.out.println(exception.getMessage());
    }

}
