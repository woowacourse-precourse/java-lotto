package lotto.participant;

import lotto.constant.message.GuideMessage;
import lotto.domain.Lotto;
import lotto.constant.Rank;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
        Arrays.stream(Rank.values()).forEach(value ->
                System.out.println(value + " - " + tallyOfRanks.getOrDefault(value, 0) + "개"));
        System.out.println("=========================");
    }

    public void showRateOfReturn(double rateOfReturn) {
        System.out.println("총 수익률은 " + BigDecimal.valueOf(rateOfReturn) + "%입니다.");
    }
}
