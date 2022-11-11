package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

import static lotto.constant.MessageConstant.OUTPUT_PURCHASE;
import static lotto.constant.MessageConstant.STATISTICS_MESSAGE;
import static lotto.constant.MessageConstant.STATISTICS_THREE_MATCH;
import static lotto.constant.MessageConstant.STATISTICS_FOUR_MATCH;
import static lotto.constant.MessageConstant.STATISTICS_FIVE_MATCH;
import static lotto.constant.MessageConstant.STATISTICS_FIVE_MATCH_ONE_BONUS;
import static lotto.constant.MessageConstant.STATISTICS_SIX_MATCH;
import static lotto.constant.MessageConstant.OUTPUT_EARNING;

import static lotto.constant.UtilConstant.LOTTO_OPEN;
import static lotto.constant.UtilConstant.LOTTO_CLOSE;
import static lotto.constant.UtilConstant.COMMA_AND_SPACE;

public class OutputView {

    public void printPurchaseCount(int lottoCount){
        System.out.printf(OUTPUT_PURCHASE,lottoCount);
    }

    public void printStatistics(List<Integer> lottoStatistics){
        System.out.println(STATISTICS_MESSAGE);
        System.out.printf(STATISTICS_THREE_MATCH, lottoStatistics.get(0));
        System.out.printf(STATISTICS_FOUR_MATCH, lottoStatistics.get(1));
        System.out.printf(STATISTICS_FIVE_MATCH, lottoStatistics.get(2));
        System.out.printf(STATISTICS_FIVE_MATCH_ONE_BONUS, lottoStatistics.get(3));
        System.out.printf(STATISTICS_SIX_MATCH, lottoStatistics.get(4));
    }

    public void printEarning(float earning){
        System.out.printf(OUTPUT_EARNING,earning);
    }

    public void printLottoNumbers(Lotto lotto) {
        StringBuilder result = new StringBuilder(LOTTO_OPEN);
        for (int lottoNumber : lotto.get()) {
            result.append(lottoNumber).append(COMMA_AND_SPACE);
        }
        result.delete(result.length() - 2, result.length()).append(LOTTO_CLOSE);
        System.out.println(result);
    }
}
