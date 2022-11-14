package lotto.view.output;

import lotto.domain.Lottos;
import lotto.domain.RankingType;

import java.util.Map;

import static lotto.util.Constants.*;

public class Guide {

    public void printInputPriceGuide() {
        System.out.println(INPUT_PRICE_GUIDE);
    }

    public void printLottoCount(long lottoCount) {
        System.out.printf(LOTTO_COUNT_GUIDE, lottoCount);
    }

    public void printInputWinningLottoGuide() {
        System.out.println(INPUT_WINNING_LOTTO_GUIDE);
    }

    public void printInputBonusGuide() {
        System.out.println(INPUT_BONUS_GUIDE);
    }

    public void printLottoGroup(Lottos lottoGroup) {
        System.out.println(lottoGroup.getLottosString());
    }

    public void printResultStartGuide() {
        System.out.println(RESULT_START_GUIDE);
    }

    public void printResult(Map<RankingType, Integer> countByRankingType) {
        ResultStatics resultStatics = new ResultStatics();
        System.out.println(resultStatics.getString(countByRankingType));
    }

    public void printProfitRate(double profitRate) {
        System.out.printf(PROFIT_RATE_GUIDE, profitRate);
    }

}
