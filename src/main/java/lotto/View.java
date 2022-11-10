package lotto;

import java.util.List;

public class View {

    public void printStartMessage() {
        System.out.println("구입금액을 입력해 주세요");
    }
    public void printPurchaseList(List<List<Integer>> purchases) {
        System.out.println(purchases.size()+"개를 구매했습니다.");
        for (List<Integer> purchase : purchases) {
            System.out.println(purchase);
        }
    }

    public void printNeedWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printNeedBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printWinningStatistics(int[] winnings) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+winnings[0]+"개");
        System.out.println("4개 일치 (50,000원) - "+winnings[1]+"개");
        System.out.println("5개 일치 (1,500,000원) - "+winnings[2]+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+winnings[4]+"개");
        System.out.print("6개 일치 (2,000,000,000원) - "+winnings[3]+"개");
    }

    public void printEarningsRate(double rate) {
        System.out.println("총 수익률은 "+rate+"%입니다.");
    }


}
