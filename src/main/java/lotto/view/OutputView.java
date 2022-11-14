package lotto.view;

import lotto.Lotto;
import lotto.Winning;

import java.util.Comparator;
import java.util.List;

import static lotto.Game.count;
import static lotto.Game.lottos;

public class OutputView extends View{
    private static List<Integer> sortedList;
    public static void countView(){
        changeLine();
        System.out.printf("%d개를 구매했습니다.",count);
        changeLine();
    }
    public static void lottoView(){
        lottos.stream().forEach(lotto -> System.out.println(lotto.sortedNumbers()));
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
        changeLine();
        System.out.println("당첨 통계");
        System.out.println("---");
    }
    public static void rateView(Float rate){
        System.out.printf("총 수익률은 %.1f%s입니다.",rate,"%");
    }
}
