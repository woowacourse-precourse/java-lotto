package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResultSummary;
import lotto.domain.LottoTickets;

import java.util.List;

public class OutputView {

    private static final String LOTTO_TICKET_COUNT = "%d개를 구매했습니다.";
    private static final String LOTTO_TICKET_NUMBERS = "[%s]";
    private static final String ERROR_MESSAGE = "[ERROR] %s";
    private static final String LOTTO_RESULT_SUMMARY = "당첨 통계\n" + "---";

    public static void printLottoTickets(LottoTickets lottoTickets) {
        List<Lotto> lottoTicketList = lottoTickets.getLottoTickets();
        System.out.println(String.format(LOTTO_TICKET_COUNT, lottoTicketList.size()));
        lottoTicketList.forEach(lottoTicket ->
                        System.out.println(String.format(LOTTO_TICKET_NUMBERS, lottoTicket.getSortedNumbers())));
        System.out.println();
    }

    public static void printSummary(LottoResultSummary summary) {
        System.out.println(LOTTO_RESULT_SUMMARY);
        System.out.println(summary.summaryLottoResult());
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(String.format(ERROR_MESSAGE, errorMessage));
    }
}
