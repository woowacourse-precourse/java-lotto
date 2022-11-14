package lotto;

import static lotto.LottoState.*;

import java.util.List;
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

    public static void printMoneyErrorMessage(){
        System.out.println("[ERROR] 잘못된 금액이 입력되었습니다.");
    }

    public static void printInputErrorMessage(){
        System.out.println("[ERROR] 잘못된 번호가 입력되었습니다.");
    }

    public static void printLottos(List<Lotto> Lottos){
        for(Lotto lotto : Lottos){
            System.out.println(lotto.asSortedList());
        }
    }

    public static void printResult(Map<String,Integer> allResult){
        System.out.println(MATCH_THREE.getName() + allResult.get("3") + "개");
        System.out.println(MATCH_FOUR.getName() + allResult.get("4") + "개");
        System.out.println(MATCH_FIVE.getName() + allResult.get("5") + "개");
        System.out.println(MATCH_FIVE_WITH_BONUS.getName() + allResult.get("7") + "개");
        System.out.println(MATCH_SIX.getName() + allResult.get("6") + "개");
    }

    public static void printProfitRate(String totalProfitRate){
        System.out.println("총 수익률은 " + totalProfitRate + "%입니다.");
    }
}
