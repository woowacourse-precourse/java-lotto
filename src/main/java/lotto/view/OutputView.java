package lotto.view;

import java.util.Map;
import lotto.domain.Rank;
import lotto.domain.User;

public class OutputView {
    public void printAskBuyingLottoPriceMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printBuyingLottoQuantityMessage(User user) {
        System.out.println();
        System.out.println((user.getPrice() / 1000) + "개를 구매했습니다.");
    }

    public void printUserLottoNumbers(User user) {
        user.getUserLottos().stream().forEach(userLotto -> {
            System.out.println(userLotto.getLottoNumbers());
        });
    }

    public void printAskLottoNumbersMessage() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printAskBonusNumberMessage() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printTotalResultMessage(Map<Rank, Integer> countPrize) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + countPrize.getOrDefault(Rank.THIRD, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + countPrize.getOrDefault(Rank.FOURTH, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + countPrize.getOrDefault(Rank.FIVE, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + countPrize.getOrDefault(Rank.FIVE_WITH_BONUS, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + countPrize.getOrDefault(Rank.SIX, 0) + "개");
    }

    public void printEarningRateOfLottoMessage(String earningRate) {
        System.out.println("총 수익률은 " + earningRate + "%입니다.");
    }




}
