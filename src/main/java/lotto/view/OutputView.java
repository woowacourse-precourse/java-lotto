package lotto.view;

import lotto.domain.LottoRank;

import java.util.EnumMap;
import java.util.List;

public class OutputView {

    private final String LOTTO_PURCHASE_PRICE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private final String LOTTO_PURCHASE_COMPLETE_MESSAGE = "개를 구매했습니다.";
    private final String OPENING_BRACKET = "(";
    private final String CLOSING_BRACKET = ")";
    private final String ONE_SPACE = " ";
    private final String COMMA = ",";
    private final String NUMBER_OF_THING = "개";

    public LottoRank lottoRank;
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
        System.out.println(LottoRank.FIFTH.getResultMessage() + lottoResult.get(4) + NUMBER_OF_THING);
        System.out.println(LottoRank.FOURTH.getResultMessage() + lottoResult.get(3) + NUMBER_OF_THING);
        System.out.println(LottoRank.THIRD.getResultMessage() + lottoResult.get(2) + NUMBER_OF_THING);
        System.out.println(LottoRank.SECOND.getResultMessage() + lottoResult.get(1) + NUMBER_OF_THING);
        System.out.println(LottoRank.FIRST.getResultMessage() + lottoResult.get(0) + NUMBER_OF_THING);
    }

    public void printLottoEarningRate(String earningRate) {
        System.out.println("총 수익률은 "+ earningRate +"%입니다.");
    }
}