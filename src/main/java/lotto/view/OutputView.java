package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoMaker;
import lotto.domain.Rank;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class OutputView {

    public static void printLottoTicktesCount(int ticketCount){
        System.out.printf("%d개를 구매했습니다.\n", ticketCount);
    }

    public static void printLottoTikects(List<Lotto> lottoTickets){
        for(Lotto lotto : lottoTickets){
            List<Integer> lottoNumbers = lotto.getNumbers();
            List<Integer> sorted = lottoNumbers.stream()
                    .sorted()
                    .collect(Collectors.toList());
            System.out.println(sorted);
        }
    }

    public static void printWinningStatistics(Map<Rank, Integer> result){
        System.out.println("당첨 통계\n---");
        DecimalFormat df = new DecimalFormat("###,###");
        for (Rank rank:result.keySet()) {
            String money = df.format(rank.getMoney());
            System.out.printf("%d개 일치 (%s원) - %d개\n", rank.getCorrectNumCount(),money,result.get(rank));
        }

    }

    public static void main(String[] args) {
        Map<Rank,Integer> result = new TreeMap<>();
        result.put(Rank.FIFTH,1);
        result.put(Rank.FOURTH,0);
        result.put(Rank.THIRD,0);
        result.put(Rank.SECOND,0);
        result.put(Rank.FIRST,0);
        printWinningStatistics(result);
    }

}
