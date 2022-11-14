package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.resource.message.FixedMessage;

public class OutputView {

    public void printLottoTicketInformation(List<Lotto> lottoTicket) {
        System.out.println("\n" + lottoTicket.size() + FixedMessage.OUTPUT_LOTTO_COUNT.getMessage());
        printSortedLottoNumbers(lottoTicket);
    }

    public void printSortedLottoNumbers(List<Lotto> lottoTicket) {
        for (Lotto lotto : lottoTicket) {
            System.out.println(lotto.getNumbers().stream().sorted().collect(Collectors.toList()));
        }
    }
}
