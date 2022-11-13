package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoTicket;

import java.util.List;

public class OutputView {
    public static void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public static void printTicketCount(long count) {
        System.out.println(count+"개를 구매했습니다.");
    }

    public static void printLottoTickets(LottoTicket lottoTicket){
        for(Lotto lotto : lottoTicket.getLottoTickets()){
            System.out.println(convertToString(lotto));
        }
    }

    private static String convertToString(Lotto lotto){
        return lotto.getNumbers().toString();

    }

}
