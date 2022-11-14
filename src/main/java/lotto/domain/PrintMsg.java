package lotto.domain;

import java.util.Map;

public class PrintMsg {
    public void printMoneyInputMsg() {
        System.out.println("구입금액을 입력해 주세요.");
    }
    public void printNumberOfLottosMsg(int numOfLottos) {
        System.out.println(numOfLottos+"개를 구매했습니다.");
    }
    public void printWinnerInputMsg() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }
    public void printBonusInputMsg() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
    public void printComparison(Map<Ranking, Integer> comparison) {
        for (Ranking rank : Ranking.values()) {
            System.out.print(rank.getDescription() + comparison.get(rank)+"개");
        }
    }
}
