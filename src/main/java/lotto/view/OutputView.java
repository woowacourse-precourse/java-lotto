package lotto.view;

import lotto.Winning;

import static lotto.Game.count;
import static lotto.Game.lottos;

public class OutputView{
    private static void changeLine(){
        System.out.println();
    }
    public static void countView(){
        System.out.printf("%d개를 구매했습니다.",count);
        changeLine();
    }
    public static void lottoView(){
        lottos.stream().forEach(lotto -> lotto.printNumbers());
        changeLine();
    }

    public static void ResultView(){
        resultTitleView();
        for(Winning winning: Winning.values()){
            printResultView(winning);
            changeLine();
        }
    }
    private static void printResultView(Winning winning){
        if(winning.bonus){
            System.out.printf("%d개 일치, 보너스 볼 일치 (%s) - %d개", winning.match,winning.priceText,winning.count);
            return;
        }
        System.out.printf("%d개 일치 (%s) - %d개", winning.match,winning.priceText,winning.count);
    }
    private static void resultTitleView(){
        System.out.println("당첨 통계");
        System.out.println("---");
    }
    public static void rateView(Float rate){
        System.out.printf("총 수익률은 %.1f%s입니다.",rate,"%");
    }
}
