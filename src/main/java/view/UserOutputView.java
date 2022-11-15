package view;

import domain.Lotto;
import domain.LottoResult;
import domain.PurchaseMoney;

public class UserOutputView {

    public static void printPurchaseLottoNumber(Lotto lotto) {
        System.out.println(lotto);
    }

    public static void printLottoResult(LottoResult lottoResult){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + lottoResult.getThreeCount() + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoResult.getFourCount() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoResult.getFiveCount() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoResult.getFiveAndBonusCount() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoResult.getSixCount() + "개");
        System.out.println();
        System.out.println("총 수익률은 " + lottoResult.getYield() + "%입니다.");
    }

    public static void printPurchaseNumber(PurchaseMoney purchaseMoney){
        System.out.println();
        System.out.println(purchaseMoney.getNumberLotteryPurchasesAvailable() + "개를 구매했습니다.");
    }

}
