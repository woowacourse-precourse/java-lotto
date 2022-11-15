package lotto.View;

import lotto.Model.enums.Prize;

import java.util.List;

public class OutputView {
    private final String OUTPUT_PURCHASE_MESSAGE = "개를 구매했습니다.";
    private final String OUTPUT_STATISTIC_MESSAGE = "당첨 통계";
    private final String OUTPUT_DASH_MESSAGE = "---";
    private final String OUTPUT_COUNT_MESSAGE = "개";
    private final String OUTPUT_YEILD_MESSAGE = "총 수익률은 ";
    private final String OUTPUT_PERCENT_MESSAGE = "%입니다.";


    public void printLottoCount(int lottoCount){
        System.out.println(lottoCount + OUTPUT_PURCHASE_MESSAGE);
    }

    public void printLottoList(List<List<Integer>> lottoes){
        for(List<Integer> l : lottoes){
            System.out.println(l);
        }
    }

    public void printStatistic(double yeild){
        System.out.println(OUTPUT_STATISTIC_MESSAGE);
        System.out.println(OUTPUT_DASH_MESSAGE);

        for(int i = 0; i<5; i++){
            System.out.print(Prize.values()[i].getMessage());
            System.out.println(Prize.values()[i].getPrizeCount() + OUTPUT_COUNT_MESSAGE);
        }

        System.out.print(OUTPUT_YEILD_MESSAGE);
        System.out.print(yeild);
        System.out.println(OUTPUT_PERCENT_MESSAGE);
    }
}
