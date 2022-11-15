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






}
