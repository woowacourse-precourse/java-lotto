package lotto.view;


import lotto.LottoWinningRank;
import lotto.service.LottoGameService;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String PURCHASE_LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String LOTTO_RANK_FIFTH_MESSAGE = "3개 일치 (5,000원) - ";
    private static final String LOTTO_RANK_FOURTH_MESSAGE = "4개 일치 (50,000원) - ";
    private static final String LOTTO_RANK_THIRD_MESSAGE = "5개 일치 (1,500,000원) - ";
    private static final String LOTTO_RANK_SECOND_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String LOTTO_RANK_FIRST_MESSAGE = "6개 일치 (2,000,000,000원) - ";
    private static final String COUNT_UNIT = "개";

    public void printPurchaseLottoCount(int purchaseLottoCount) {
        System.out.println(purchaseLottoCount + PURCHASE_LOTTO_COUNT_MESSAGE);
    }

    public void printIssuedLottoNumbers(List<Integer> issuedLottoNumbers) {
        System.out.println(issuedLottoNumbers.toString());
    }

    public void printLottoWinningStatistics(Map<LottoWinningRank, Integer> lottoWinningRankMap) {
        System.out.println(LOTTO_RANK_FIFTH_MESSAGE + lottoWinningRankMap.get(LottoWinningRank.FIFTH) + COUNT_UNIT);
        System.out.println(LOTTO_RANK_FOURTH_MESSAGE + lottoWinningRankMap.get(LottoWinningRank.FOURTH) + COUNT_UNIT);
        System.out.println(LOTTO_RANK_THIRD_MESSAGE + lottoWinningRankMap.get(LottoWinningRank.THIRD) + COUNT_UNIT);
        System.out.println(LOTTO_RANK_SECOND_MESSAGE + lottoWinningRankMap.get(LottoWinningRank.SECOND) + COUNT_UNIT);
        System.out.println(LOTTO_RANK_FIRST_MESSAGE + lottoWinningRankMap.get(LottoWinningRank.FIRST) + COUNT_UNIT);
    }
}
