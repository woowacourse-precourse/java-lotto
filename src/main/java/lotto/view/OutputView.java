package lotto.view;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.User;
import lotto.domain.UserLotto;

public class OutputView {
    public void askBuyingPriceView() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void responseBuyingQuantity(int quantity, User user) {
        System.out.println(quantity + "개를 구매했습니다.");

        user.getLottos().stream().forEach(userLotto -> {
            System.out.println(userLotto.getNumbers());
        });
    }

    public void askNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void askBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

//    public void responseResult() {
//        System.out.println("당첨 통계");
//        System.out.println("---");
//    }
}
