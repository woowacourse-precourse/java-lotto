package lotto;

import static lotto.LottoState.*;

import java.util.Map;

public class printUI {
    public static void printMoneyInputMessage() {
        System.out.println("구입금액을 입력해주세요.");
    }

    public static void printWinningNumberInputMessage(){
        System.out.println("\n" +"당첨 번호를 입력해주세요.");
    }

    public static void printBonusNumberInputMessage(){
        System.out.println("\n" +"보너스 번호를 입력해주세요.");
    }

    public static void printAnalysisMessage(){
        System.out.println("당첨 통계\n___");
    }

    public static void printResult(Map<String,Integer> allResult){
        System.out.println(MATCH_THREE.getName() + allResult.get("3") + "개");
        System.out.println(MATCH_FOUR.getName() + allResult.get("4") + "개");
        System.out.println(MATCH_FIVE.getName() + allResult.get("5") + "개");
        System.out.println(MATCH_FIVE_WITH_BONUS.getName() + allResult.get("7") + "개");
        System.out.println(MATCH_SIX.getName() + allResult.get("6") + "개");
    }

    public static void printProfitRate(Map<String,Integer> allResult , int money){
        int totalProfit = allResult.get("3") * 5000 +
                allResult.get("4") * 50000 +
                allResult.get("5") * 1500000 +
                allResult.get("7") * 30000000 +
                allResult.get("6") * 2000000000;
        System.out.println("총 수익률은 " + ((double)totalProfit / money * 100) + "%입니다.");
    }
}
