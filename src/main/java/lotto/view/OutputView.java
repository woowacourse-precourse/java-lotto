package lotto.view;

import java.util.List;

public class OutputView {
    public final int PRICE_PER_LOTTO = 1000;

    public void printLottoPurchaseCompleteMessage(int lottoChance) {
        System.out.println(lottoChance + "개를 구매했습니다.");
    }

    public void printLottoNumber(List<List<Integer>> allLottoNumber) {
        for (List<Integer> lottoNumbers : allLottoNumber) {
            System.out.println(lottoNumbers);
        }
    }

    public void printLottoRankResult(List<Integer> lottoResult) {
        System.out.println("3개 일치 (5,000원) - " + lottoResult.get(4));
        System.out.println("4개 일치 (50,000원) - " + lottoResult.get(3));
        System.out.println("5개 일치 (1,500,000원) - " + lottoResult.get(2));
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoResult.get(1));
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoResult.get(0));
    }
}