package lotto.view;

import lotto.domain.game.Ranking;
import lotto.domain.player.Player;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import static lotto.view.OutputString.*;

public class OutputView {
    public static void printLottoTickets(Player player){
        List<List<Integer>> lottoTickets = player.getLottoTickets();
        int count = lottoTickets.size();
        System.out.println(TICKET_QUANTITY_MESSAGE.print(count));
        printEachLottoTickets(lottoTickets);
    }

    public static void printEachLottoTickets(List<List<Integer>> lottoTickets) {
        for (List<Integer> lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
    }

    public static void printWinningStatistics(Player player){
        player.getWinningResult().entrySet().stream().filter(entry -> entry.getKey() != Ranking.DEFAULT)
                .sorted(Collections.reverseOrder(Entry.comparingByKey()))
                .forEach(entry -> System.out.println(entry.getKey().toString()
                        + String.format(PHRASES_RANKING_COUNT.print(entry.getValue()))));
    }

    public static void printReturnRate(Player player){
        System.out.println(RETURNRATE_MESSAGE.print(player.getReturnRate()));
    }
}
