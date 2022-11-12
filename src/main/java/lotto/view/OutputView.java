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
}