package lotto;

import lotto.domain.User;
import lotto.domain.Winning;
import lotto.utils.ConsoleUtil;

public class Application {
    public static void main(String[] args) {
        User user = new User();
        Winning winning = new Winning();

        try {
            user.buyLotto();
            user.showBuyResult();

            winning.inputNumbers();
            winning.inputBonusNumber();

            user.showLottoResult(winning);
        } catch (IllegalArgumentException ex) {
            ConsoleUtil.showMessage(ex.getMessage());
        }
    }
}
