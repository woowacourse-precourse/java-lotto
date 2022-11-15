package lotto.view;

import lotto.domain.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String OUTPUT_AMOUNT_OF_LOTTO = "개를 구매했습니다.";

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void outputLottoTickets(List<Lotto> lottoTickets) {
        System.out.println(lottoTickets.size() + OUTPUT_AMOUNT_OF_LOTTO);
        for (Lotto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.getNumbers().stream().sorted().collect(Collectors.toList()));
        }
    }

}
