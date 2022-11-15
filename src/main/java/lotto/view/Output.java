package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.enumeration.Rating;

import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.List;

public class Output {

    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String LINE = "---";
    private static final String RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";
    private static final String BONUS_MATCH_PHRASE_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String MATCH_PHRASE = "%d개 일치 (%s원) - %d개\n";

    public void printNumberOfLotto(int lottoQuantity){
        System.out.println(lottoQuantity + PURCHASE_MESSAGE);
    }

    public void printLottoNumbers(List<Lotto> lottoNumbers){
        for(Lotto lotto : lottoNumbers){
            System.out.println(lotto);
        }
    }

    public void printStatisticsMessage(){
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(LINE);
    }

    public void printStatistics(LinkedHashMap<Rating, Integer> statistics, int money){
        int accumulation = 0;
        for(Rating rating : statistics.keySet()){
            accumulation += printStatisticsOfEach(rating, statistics.get(rating));
        }
        printTotalYield(money, accumulation);
    }

    private void printTotalYield(int money, int accumulation) {
        System.out.printf(RATE_MESSAGE, ((float)accumulation/money * 100));
    }

    private int printStatisticsOfEach(Rating rating, int count) {
        if(rating == Rating.SECOND){
            System.out.printf(BONUS_MATCH_PHRASE_MESSAGE,
                    rating.getAccord(), numberFormat(rating.getPrize()), count);
            return rating.getAccord() * count;
        }
        System.out.printf(MATCH_PHRASE, rating.getAccord(), numberFormat(rating.getPrize()), count);
        return rating.getPrize() * count;
    }

    private String numberFormat(int number){
        NumberFormat numberFormat = NumberFormat.getInstance();
        return numberFormat.format(number);
    }
}
