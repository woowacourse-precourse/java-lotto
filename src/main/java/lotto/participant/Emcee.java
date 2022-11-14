package lotto.participant;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static lotto.domain.Rank.*;

public class Emcee {

    public void guideGame() {
        String startingGuide = "Lotto game 에 오신 것을 환영합니다.\n" +
                "원하시는 만큼의 lotto 를 구매할 수 있으며 lotto 는 자동 발행됩니다.\n" +
                "당첨 번호와 보너스 번호를 생성하면 발행된 lotto 들의 당첨 여부를 계산합니다.\n" +
                "최종적으로 당첨 통계와 수익률을 알려드립니다.\n" +
                "게임을 시작하겠습니다.";
        System.out.println(startingGuide);
    }

    public void guideAmountOfPurchaseMoney() {
        String guide = "구입 금액을 입력해주세요.\n" +
                "구입 금액은 1,000원 단위로 입력이 가능합니다.";
        System.out.println(guide);
    }

    public void showPublishedLottos(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        System.out.println("Lotto 정보는 다음과 같습니다.");
        System.out.println("==================================================");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println("==================================================\n");
    }

    public void guideWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        System.out.println("당첨 번호는 1과 45 사이의 서로 다른 6개의 숫자입니다.");
        System.out.println("각 번호를 쉼표로 구분해서 입력해주세요.");
    }

    public void guideBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        System.out.println("보너스 번호는 당첨 번호와 중복되지 않는 1부터 45 사이의 숫자입니다.");
        System.out.println("하나의 보너스 번호만 입력해 주세요.");
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
