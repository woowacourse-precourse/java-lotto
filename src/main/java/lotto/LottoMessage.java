package lotto;

import lotto.domain.Lotto;

import java.util.List;

public class LottoMessage {
    public void printPurchaseMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printPurchasedLotteries(List<Lotto> lotteries) {
        for (Lotto lotto : lotteries) {
            System.out.println(lotto.toString());
        }
    }

    public void printInputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printInputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
