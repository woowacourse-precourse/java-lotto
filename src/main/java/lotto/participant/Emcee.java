package lotto.participant;

import lotto.constant.GuideMessage;
import lotto.domain.Lotto;
import lotto.constant.Rank;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static lotto.constant.Rank.*;

public class Emcee {

    public void guideGame() {
        System.out.println(GuideMessage.STARTING_GUIDE);
    }

    public void guideAmountOfPurchaseMoney() {
        System.out.println(GuideMessage.PURCHASE_GUIDE);
    }

    public void guideWinningNumber() {
        System.out.println(GuideMessage.WINNING_NUMBERS_GUIDE);
    }

    public void guideBonusNumber() {
        System.out.println(GuideMessage.BONUS_NUMBER_GUIDE);
    }

    public void showPublishedLottos(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        System.out.println("Lotto 정보는 다음과 같습니다.");
        System.out.println("==================================================");
        lottos.forEach(System.out::println);
        System.out.println("==================================================\n");
    }

    public void showStatistics(Map<Rank, Integer> tallyOfRanks) {
        System.out.println("\n당첨 통계입니다.");
        System.out.println("=========================");
        System.out.println("3개 일치 (5,000원) - "
                + tallyOfRanks.getOrDefault(FIFTH_THREE_MATCHED, 0) + "개");
        System.out.println("4개 일치 (50,000원) - "
                + tallyOfRanks.getOrDefault(FOURTH_FOUR_MATCHED, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - "
                + tallyOfRanks.getOrDefault(THIRD_FIVE_MATCHED, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "
                + tallyOfRanks.getOrDefault(SECOND_FIVE_WITH_BONUS, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - "
                + tallyOfRanks.getOrDefault(FIRST_SIX_MATCHED, 0) + "개");
        System.out.println("=========================");
    }

    public void showRateOfReturn(double rateOfReturn) {
        System.out.println("총 수익률은 " + BigDecimal.valueOf(rateOfReturn) + "%입니다.");
    }
}
