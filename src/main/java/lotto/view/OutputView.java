package lotto.view;

import lotto.domain.LottoRank;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String LOTTO_PURCHASE_PRICE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_PURCHASE_COMPLETE_MESSAGE = "개를 구매했습니다.";
    private static final String NUMBER_OF_THING = "개";

    public static void printPriceInputMessage() {
        System.out.println(LOTTO_PURCHASE_PRICE_INPUT_MESSAGE);
    }

    public static void printLottoPurchaseCompleteMessage(int lottoChance) {
        System.out.println(lottoChance + LOTTO_PURCHASE_COMPLETE_MESSAGE);
    }

    public static void printLottoNumber(List<Integer> lotto) {
        System.out.println(lotto);
    }

    public static void printLottoResult(Map<LottoRank, Integer> result) {
        System.out.println(LottoRank.FIFTH.getResultText()+ result.get(LottoRank.FIFTH)+NUMBER_OF_THING);
        System.out.println(LottoRank.FOURTH.getResultText()+ result.get(LottoRank.FOURTH)+NUMBER_OF_THING);
        System.out.println(LottoRank.THIRD.getResultText()+ result.get(LottoRank.THIRD)+NUMBER_OF_THING);
        System.out.println(LottoRank.SECOND.getResultText()+ result.get(LottoRank.SECOND)+NUMBER_OF_THING);
        System.out.println(LottoRank.FIRST.getResultText()+ result.get(LottoRank.FIRST)+NUMBER_OF_THING);
    }

    public static void printLottoEarningRate(double earningRate) {
        System.out.println("총 수익률은 "+ earningRate +"%입니다.");
    }
}