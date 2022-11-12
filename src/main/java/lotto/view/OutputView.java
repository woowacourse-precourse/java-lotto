package lotto.view;

import java.util.List;

public class OutputView {

    private final String LOTTO_PURCHASE_PRICE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private final String LOTTO_PURCHASE_COMPLETE_MESSAGE = "개를 구매했습니다.";
    private final String OPENING_BRACKET = "(";
    private final String CLOSING_BRACKET = ")";
    private final String ONE_SPACE = " ";
    private final String COMMA = ",";

    public void printPriceInputMessage() {
        System.out.println(LOTTO_PURCHASE_PRICE_INPUT_MESSAGE);
    }

    public void printLottoPurchaseCompleteMessage(int lottoChance) {
        System.out.println(lottoChance + LOTTO_PURCHASE_COMPLETE_MESSAGE);
    }

    public void printLottoNumber(List<List<Integer>> allLottoNumber) {
        for (List<Integer> lottoNumbers : allLottoNumber) {
            System.out.println(lottoNumbers);
        }
    }

    public void printLottoRankResult(List<Integer> lottoResult) {
        System.out.println("3개 일치 (5,000원) - " + lottoResult.get(4) + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoResult.get(3) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoResult.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoResult.get(1) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoResult.get(0) + "개");
    }

    public void printLottoEarningRate(String earningRate) {
        System.out.println("총 수익률은 "+ earningRate +"%입니다.");
    }
}