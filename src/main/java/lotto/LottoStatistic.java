package lotto;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class LottoStatistic {
    private List<LottoRanking> lottoRankings;

    public LottoStatistic(RandomLottos randomLottos, WinningLotto winningLotto){
        lottoRankings = randomLottos.createLottoRankingsBy(winningLotto);
    }

    private int findCountOfRanking(LottoRanking ranking){
        return (int) lottoRankings.stream()
                .filter(r -> r.equals(ranking))
                .count();
    }

    private String createStatisticStringFormat(LottoRanking ranking){
        DecimalFormat decFormat = new DecimalFormat("###,###");
        int countOfRanking = findCountOfRanking(ranking);
        String prize = decFormat.format(ranking.getPrice());

        if(ranking == LottoRanking.SECOND_PLACE){
            return String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개"
                    , ranking.getMatch(), prize, countOfRanking);
        }
        return String.format("%d개 일치 (%s원) - %d개", ranking.getMatch(),prize,countOfRanking);
    }

    public void printStatistic(){
        System.out.println("\n당첨 통계\n---");
        Arrays.stream(LottoRanking.values())
                .filter(ranking -> ranking != LottoRanking.ETC)
                .map(this::createStatisticStringFormat)
                .forEach(System.out::println);
        printEarningRate();
    }

    private void printEarningRate(){
        int startMoney = 1000*lottoRankings.size();
        int endMoney = Arrays.stream(LottoRanking.values())
                .map(ranking -> findCountOfRanking(ranking) * ranking.getPrice())
                .reduce(0,Integer::sum);
        double rate = (double)endMoney / startMoney * 100;
        System.out.println("총 수익률은 " + (Math.round(rate*100)/100.0)+ "%입니다.");
    }

}
