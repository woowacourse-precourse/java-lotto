package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Winning;


import static lotto.Game.count;
import static lotto.Game.lottos;

public class View {
    protected static String inputMoneyView(){
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    protected static String inputWinningView(){
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    protected static String inputBonusView(){
        changeLine();
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
    protected static void changeLine(){
        System.out.println();
    }
    protected static void countView(){
        changeLine();
        System.out.printf("%d개를 구매했습니다.",count);
        changeLine();
    }
    protected static void lottoView(){
        lottos.stream().forEach(lotto -> System.out.println(lotto.sortedNumbers()));
        changeLine();
    }

    protected static void printResultView(Winning winning){
        System.out.printf("%d개 일치 (%s) - %d개", winning.match,winning.priceText,winning.count);
    }

    protected static void printFifthView(Winning winning){
        System.out.printf("%d개 일치, 보너스 볼 일치 (%s) - %d개", winning.match,winning.priceText,winning.count);
    }
    protected static void resultTitleView(){
        changeLine();
        System.out.println("당첨 통계");
        System.out.println("---");
    }
    protected static void rateView(Double rate){
        System.out.printf("총 수익률은 %.1f%s입니다.",rate,"%");
    }
}
