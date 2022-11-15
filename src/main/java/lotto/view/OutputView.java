package lotto.view;

import java.util.Map;
import lotto.domian.User;
import lotto.domian.WinningCriteria.WinningCriteriaInfo;
import static lotto.constant.Constant.*;


public class OutputView {
    public void printBuyingPriceQuestion() {
        System.out.println("구입 금액을 입력해 주세요.");
    }
    public void printUserLottoQuantity(long lottoQuantity) {
        System.out.println();
        System.out.println(lottoQuantity + "개를 구매했습니다.");
    }
    public void printUserLottoNumbers(User user) {
        user.getUserLottoNumbers()
          .forEach(userSingleLottoNumber -> System.out.println(userSingleLottoNumber.getLottoNumbers()));
    }
    public void printWinningNumberQuestion() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요");
    }
    public void printBonusNumberQuestion() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요");
    }
    public void printUserWinningResult(Map<WinningCriteriaInfo, Integer> winningInfo) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        for (WinningCriteriaInfo price : WinningCriteriaInfo.values()) {
            if (price.getLabel() < LOWEST_RANK_MATCHED_LOTTO_NUMBERS) {
                continue;
            }
            System.out.println(price.getRankInfo() + winningInfo.getOrDefault(price, INITIAL_NUMBER) + "개");
        }
    }
}
