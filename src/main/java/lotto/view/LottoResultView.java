package lotto.view;

import lotto.model.LottoResult;

public class LottoResultView {

    public void printResult(LottoResult lottoResult) {

        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + lottoResult.getFifthCount() + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoResult.getFifthCount() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoResult.getThirdCount() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoResult.getSecondCount() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoResult.getFirstCount() + "개");
        System.out.println("총 수익률은 "+ lottoResult.getProfit() + "%입니다.");
    }
}
