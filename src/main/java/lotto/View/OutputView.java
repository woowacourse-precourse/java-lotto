package lotto.View;

import lotto.Model.LottoSystem;

import java.util.Collections;
import java.util.List;

import static lotto.Model.Money.getInputMoney;
import static lotto.Model.RandomLotto.getBundleOfLottoNumbers;
import static lotto.Model.Ranking.findRanking;


public class OutputView {

    private static final int COUNT_OF_FIRST = 6;
    private static final int COUNT_OF_SECOND = 7;
    private static final int COUNT_OF_THIRD = 5;
    private static final int COUNT_OF_FOURTH = 4;
    private static final int COUNT_OF_FIFTH = 3;

    public static void printBundleOfLottoNumbers() {
        for(List<Integer> lottoNumbers: getBundleOfLottoNumbers()) System.out.println(lottoNumbers);
    }

    public static void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + getFrequency(COUNT_OF_FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + getFrequency(COUNT_OF_FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + getFrequency(COUNT_OF_THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + getFrequency(COUNT_OF_SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + getFrequency(COUNT_OF_FIRST) + "개");
    }

    private static int getFrequency(int countOfRanking) {
        return Collections.frequency(LottoSystem.getWinningStatics(), countOfRanking);
    }

    public static void printYield() {
        double sum = 0.0;
        for(int countOfCase : LottoSystem.getWinningStatics()) {
            if(countOfCase == COUNT_OF_FIRST) sum+= findRanking(countOfCase).getPrize();
            if(countOfCase == COUNT_OF_SECOND) sum+= findRanking(countOfCase).getPrize();
            if(countOfCase == COUNT_OF_THIRD) sum+= findRanking(countOfCase).getPrize();
            if(countOfCase == COUNT_OF_FOURTH) sum+= findRanking(countOfCase).getPrize();
            if(countOfCase == COUNT_OF_FIFTH) sum+= findRanking(countOfCase).getPrize();
        }
        sum /= getInputMoney();
        sum *= 100;
        System.out.println("총 수익률은 " + String.format("%.1f", sum) + "%입니다.");
    }


}
