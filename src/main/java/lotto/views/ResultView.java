package lotto.views;

import lotto.domain.Result;

public class ResultView {

    public static final int LOTTO_PRICE = 1000;

    public static void printWinningResult(Result lottoResult) {
        printResultMessage();
        printPlace(lottoResult);
        printYield(lottoResult);
    }

    private static void printYield(Result lottoResult) {
        double reward = lottoResult.getReward();
        double lottoPurchaseCost = lottoResult.getLottoSize() * LOTTO_PRICE;
        double yield = Math.round(reward / lottoPurchaseCost * 1000.0) / 10.0;

        System.out.println("총 수익률은 " + yield + "%입니다.");
    }

    private static void printPlace(Result lottoResult) {
        System.out.println("3개 일치 (5,000원) - " + lottoResult.getFifth() + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoResult.getFourth() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoResult.getThird() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoResult.getSecond() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoResult.getFirst() + "개");
    }

    private static void printResultMessage() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }
}
