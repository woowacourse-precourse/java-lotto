package lotto.view;

import java.util.Map;
import lotto.domain.User;
import lotto.domain.Win;

public class OutputView {
    public void askAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void showPurchaseQuantity(User user) {
        System.out.println();
        System.out.println(getQuantity(user) + "개를 구매했습니다.");
    }

    public int getQuantity(User user) {
        return user.getAmount() / 1000;
    }

    public void showUserLottoNumber(User user) {
        user.getAutoNumbers().forEach(userLotto -> {
            System.out.println(userLotto.getNumbers());
        });
    }

    public void askLottoNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void askBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void showEachWinnings(Map<Win, Integer> matchCount) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + matchCount.getOrDefault(Win.THIRD, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + matchCount.getOrDefault(Win.FOURTH, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + matchCount.getOrDefault(Win.FIFTH, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + matchCount.getOrDefault(Win.FIFTH_WITH_BONUS, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + matchCount.getOrDefault(Win.SIXTH, 0) + "개");
    }

    public void showRateOfReturn(String yieldOfLotto) {
        System.out.println("총 수익률은 " + yieldOfLotto + "%입니다.");
    }
}