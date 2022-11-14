package lotto.view;

import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;

public class OutputView {
    public static final String TICKET_PURCHASE_SENTENCE = "개를 구매했습니다.";

    private OutputView() {
    }

    public static void printTicketCount(int ticketCount) {
        System.out.println("\n" + ticketCount + TICKET_PURCHASE_SENTENCE);
    }

    public static void printTicket(LottoTicket lottoTicket) {
        for (Lotto lotto : lottoTicket.getLottoTickets()) {
            List<Integer> lottoNumberList = lotto.getLottoNumbers();
            String sentence = joinList(convertToStringList(lottoNumberList));
            System.out.println(sentence);
        }
    }

    private static String joinList(List<String> list) {
        String str = String.join("," + " ", list);
        return String.format("%s%s%s", "[", str, "]");
    }

    private static List<String> convertToStringList(List<Integer> lottoNumberList) {
        return lottoNumberList.stream()
                .sorted(Integer::compareTo)
                .map(String::valueOf)
                .collect(Collectors.toList());
    }
}