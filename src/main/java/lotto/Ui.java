package lotto;

import java.util.HashMap;
import java.util.List;

public class Ui {
    private static final String ERROR_MESSAGE = "[ERROR]";
    public static void inputMoneyOutUi() {
        System.out.println("구입금액을 입력해 주세요");
    }
    public static void numberOfPurchaseUi(int purchaseMoney) {
        int purchaseAmount = purchaseMoney/1000;
        System.out.println(purchaseAmount +"개를 구매했습니다.");
    }
    public static void bonusInputUi() {
        System.out.println("보너스 번호를 입력해 주세요");
    }

    public static void digitInputUi() {
        System.out.println("당첨 번호를 입력해 주세요");
    }
    public static void randomPickUi(List<Integer> lottoNum) {
        System.out.println(lottoNum);
    }
    public static void exceptionMessageUi(IllegalArgumentException e) {
        System.out.println(ERROR_MESSAGE + e.getMessage());
    }
    public static void lottoOutputUi(HashMap<Integer, Integer> winNumbers, double percent) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+ winNumbers.get(3)+"개");
        System.out.println("4개 일치 (50,000원) - "+ winNumbers.get(4)+"개");
        System.out.println("5개 일치 (1,500,000원) - "+ winNumbers.get(5)+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+ winNumbers.get(7)+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+ winNumbers.get(6)+"개");
        System.out.println("총 수익률은 "+String.format("%.1f", percent)+"%입니다.");
    }

}
