package lotto.console;

import lotto.domain.Lotto;

import java.util.List;

public class Output {
    public static void askPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.value());
        }
    }

    public static void printEmptyLine() {
        System.out.println(" ");
    }

    public static void announceNumber(int number) {
        System.out.println(number + "개를 구매했습니다.");
    }

    public static void askWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void askBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printWinningStatistics() {
        System.out.println("당첨 통계");
    }

    public static void printLine() {
        System.out.println("---");
    }

    public static void printThree(int threeNumber) {
        System.out.println("3개 일치 (5,000원) - " + threeNumber);
    }

    public static void printFour(int fourNumber) {
        System.out.println("4개 일치 (50,000원) - " + fourNumber);
    }

    public static void printFive(int fiveNumber) {
        System.out.println("5개 일치 (1,500,000원) - " + fiveNumber);
    }

    public static void printFiveFlus(int fiveFlusNumber) {
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + fiveFlusNumber);
    }

    public void printSix(int sixNumber) {
        System.out.println("6개 일치 (2,000,000,000원) - " + sixNumber);
    }

    public void reportRateOfReturn() {
        System.out.println("총 수익률은" + "입니다.");
    }
}
