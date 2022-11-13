package lotto.console;

import lotto.domain.Lotto;

import java.util.List;

public class Output {
    public void askPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.value());
        }
    }

    public void printEmptyLine() {
        System.out.println(" ");
    }

    public void announceNumber(int number) {
        System.out.println(number + "개를 구매했습니다.");
    }

    public void askWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void askBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printWinningStatistics() {
        System.out.println("당첨 통계");
    }

    public void printLine() {
        System.out.println("---");
    }

    public void printThree(int threeNumber) {
        System.out.println("3개 일치 (5,000원) - " + threeNumber+"개");
    }

    public void printFour(int fourNumber) {
        System.out.println("4개 일치 (50,000원) - " + fourNumber+"개");
    }

    public void printFive(int fiveNumber) {
        System.out.println("5개 일치 (1,500,000원) - " + fiveNumber+"개");
    }

    public void printFiveFlus(int fiveFlusNumber) {
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + fiveFlusNumber+"개");
    }

    public void printSix(int sixNumber) {
        System.out.println("6개 일치 (2,000,000,000원) - " + sixNumber+"개");
    }

    public void reportRateOfReturn(double totalReturn) {
        System.out.println("총 수익률은 " + totalReturn + "%입니다.");
    }

    public void printErrorMessage(String message){
        System.out.println("[ERROR]"+ message);
    }
}
