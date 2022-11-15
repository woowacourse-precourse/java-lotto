package utils;

import lotto.domain.Lotto;

import java.util.List;

import static constant.Messages.SHOW_LOTTO_TICKETS_MESSAGE;
import static constant.Messages.SHOW_RETURN_OF_RATE_MESSAGE;

public class Output {


    public static void showLottoTickets(List<Lotto> lottoTickets) {
        System.out.println(String.format(SHOW_LOTTO_TICKETS_MESSAGE, lottoTickets.size()));
        lottoTickets.stream().forEach(System.out::println);
    }

    public static void showResult(List<String> resultMessage) {
        resultMessage.stream().forEach(System.out::println);
    }

    public static void showReturnOfRate(double returnOfRate) {
        System.out.println(String.format(SHOW_RETURN_OF_RATE_MESSAGE, returnOfRate));
    }
}
