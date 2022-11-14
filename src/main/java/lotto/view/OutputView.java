package lotto.view;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.resource.Rank;
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

    public void printWinningStatistics(Map<String, Integer> winningCountRepository, BigDecimal yield) {
        System.out.println("\n" + FixedMessage.WINNING_STATISTICS.getMessage());
        printWinningDetail(winningCountRepository);
        printYield(yield);
    }

    private void printWinningDetail(Map<String, Integer> winningCountRepository) {
        for (Rank rank : Rank.values()) {
            System.out.println(rank.getOutputMessage() + winningCountRepository.getOrDefault(rank.name(), 0) + "개");
        }
    }

    private void printYield(BigDecimal yield) {
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }
}
