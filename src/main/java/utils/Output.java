package utils;

import lotto.domain.Lotto;

import java.util.List;

public class Output {

    public static void showLottoTickets(List<Lotto> lottoTickets) {
        System.out.println(lottoTickets.size()+"개를 구매했습니다.");
        for (Lotto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
    }

    public static void showResult(List<String> resultMessage) {
        resultMessage.stream().forEach(System.out::println);
    }

    public static void showReturnOfRate(double returnOfRate) {
        System.out.println(String.format("총 수익률은 %.1f%%입니다.",returnOfRate));
    }
}
