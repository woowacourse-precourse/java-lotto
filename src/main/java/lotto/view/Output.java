package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.enumeration.Rating;

import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.List;

public class Output {

    public void printNumberOfLotto(int lottoQuantity){
        System.out.println(lottoQuantity + "개를 구매했습니다.");
    }


    public void printLottoNumbers(List<Lotto> lottoNumbers){
        for(Lotto lotto : lottoNumbers){
            System.out.println(lotto);
        }
    }

    public void printStatisticsMessage(){
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public void printStatistics(LinkedHashMap<Rating, Integer> statistics, int money){
        int accumulation = 0;
        for(Rating rating : statistics.keySet()){
            accumulation += printStatisticsOfEach(rating, statistics.get(rating));
        }
        printTotalYield(money, accumulation);
    }

    private void printTotalYield(int money, int accumulation) {
        System.out.printf("총 수익률은 %.1f%%입니다.", ((float)accumulation/money * 100));
    }

    private int printStatisticsOfEach(Rating rating, int count) {
        if(rating == Rating.SECOND){
            System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n",
                    rating.getAccord(), numberFormat(rating.getPrize()), count);
            return rating.getAccord() * count;
        }
        System.out.printf("%d개 일치 (%s원) - %d개\n", rating.getAccord(), numberFormat(rating.getPrize()), count);
        return rating.getPrize() * count;
    }

    private String numberFormat(int number){
        NumberFormat numberFormat = NumberFormat.getInstance();
        return numberFormat.format(number);
    }
}
