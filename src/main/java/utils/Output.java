package utils;

import lotto.Lotto;

import java.util.List;

public class Output {

    public static void showLottoTickets(List<Lotto> lottoTickets) {
        System.out.println(lottoTickets.size()+"개를 구매했습니다.");
        for (Lotto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
    }

    public static void showReturnOfRate(double returnOfRate) {
        System.out.println("총 수익률은 "+returnOfRate+"%입니다.");
    }
}
