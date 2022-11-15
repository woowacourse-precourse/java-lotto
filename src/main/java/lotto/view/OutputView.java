package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;

import java.util.Arrays;
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

    public static void printLottoNumber(Lotto lotto) {
        System.out.println(lotto);
    }

    public static void printLottoResult(Map<LottoRank, Integer> result) {
        Arrays.stream(LottoRank.values())
                .filter(lottoRank -> !lottoRank.equals(LottoRank.FAILED))
                .forEach(lottoRank -> printEachResult(lottoRank, result));
    }

    private static void printEachResult(LottoRank lottoRank, Map<LottoRank, Integer> result) {
        System.out.println(lottoRank.getResultText() + result.get(lottoRank) + NUMBER_OF_THING);
    }

    public static void printLottoEarningRate(double earningRate) {
        String rateResult = String.format("%.1f", earningRate);
        System.out.println("총 수익률은 " + rateResult + "%입니다.");
    }
}