package lotto.view;

import lotto.domain.game.Ranking;
import lotto.domain.player.Player;

import java.util.List;
import java.util.Map.Entry;

import static lotto.view.OutputString.*;

public class OutputView {
    public void printLottoTickets(Player player){
        List<List<Integer>> lottoTickets = player.getLottoTickets();
        int count = lottoTickets.size();
        System.out.println(TICKET_QUANTITY_MESSAGE.print(count));
        printEachLottoTickets(lottoTickets);
    }

    public void printEachLottoTickets(List<List<Integer>> lottoTickets) {
        for (List<Integer> lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
    }

    public void printWinningStatistics(Player player){
        for (Entry<Ranking, Long> entrySet : player.getWinningResult().entrySet()) {
            System.out.println(entrySet.getKey().toString()
                    + String.format(PHRASES_RANKING_COUNT.print(entrySet.getValue())));
        }
    }
}
