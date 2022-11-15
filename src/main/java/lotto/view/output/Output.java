package lotto.view.output;

import lotto.domain.Lotto;
import lotto.message.ErrorMessage;
import lotto.message.GuideMessage;
import lotto.message.NumberType;

import java.math.BigDecimal;
import java.util.List;

public class Output {

    public void printLottoCountForBuy(int count) {
        System.out.println(count + GuideMessage.BUY_LOTTO_MESSAGE.getGuideMessage());
    }

    public void printAllLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLottoNumbers());
        }
        System.out.println();
    }

    public void printResultGuideMessage() {
        System.out.println(GuideMessage.RESULT_GUIDE_TEXT_MESSAGE.getGuideMessage());
        System.out.println(GuideMessage.RESULT_GUIDE_LINE_MESSAGE.getGuideMessage());
    }

    public void printPrizeResult(int[] prizeResult) {
        System.out.println(GuideMessage.FIFTH_PRIZE_MESSAGE.getGuideMessage()
                + prizeResult[NumberType.FIFTH_PRIZE.getNumberType()]
                + GuideMessage.PRIZE_UNIT.getGuideMessage());
        System.out.println(GuideMessage.FOURTH_PRIZE_MESSAGE.getGuideMessage()
                + prizeResult[NumberType.FOURTH_PRIZE.getNumberType()]
                + GuideMessage.PRIZE_UNIT.getGuideMessage());
        System.out.println(GuideMessage.THIRD_PRIZE_MESSAGE.getGuideMessage()
                + prizeResult[NumberType.THIRD_PRIZE.getNumberType()]
                + GuideMessage.PRIZE_UNIT.getGuideMessage());
        System.out.println(GuideMessage.SECOND_PRIZE_MESSAGE.getGuideMessage()
                + prizeResult[NumberType.SECOND_PRIZE.getNumberType()]
                + GuideMessage.PRIZE_UNIT.getGuideMessage());
        System.out.println(GuideMessage.FIRST_PRIZE_MESSAGE.getGuideMessage()
                + prizeResult[NumberType.FIRST_PRIZE.getNumberType()]
                + GuideMessage.PRIZE_UNIT.getGuideMessage());
    }

    public void printProfitRate(BigDecimal profitRate) {
        System.out.println(GuideMessage.PROFIT_RATE_PREFIX_MESSAGE.getGuideMessage()
                + profitRate
                + GuideMessage.PROFIT_RATE_SUFFIX_MESSAGE.getGuideMessage());
    }
}
