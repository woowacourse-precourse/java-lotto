package lotto.view;

import lotto.Logger;
import lotto.LotteryPublisher;
import lotto.Lotto;
import lotto.User;

import java.util.List;

public class MainView {
    private final User user;
    private final LotteryPublisher publisher;

    public MainView(User user, LotteryPublisher publisher) {
        this.user = user;
        this.publisher = publisher;
    }

    public void run() {
        try {
            printInputPurchaseAmountMessage();
            Integer purchaseAmount = user.askPurchaseAmount();
            printPublishCountMessage(purchaseAmount);

            List<Lotto> purchasedLotto = publisher.publishByPurchaseAmount(purchaseAmount);
            printPurchasedLotto(purchasedLotto);

        } catch (IllegalArgumentException e) {
            Logger.printError(e.getMessage());
        }
    }

    private void printPurchasedLotto(List<Lotto> purchasedLotto) {
        purchasedLotto.stream().forEach(this::printLottoNumber);
    }

    private void printPublishCountMessage(int purchaseAmount) {
        System.out.println();
        System.out.println(purchaseAmount / LotteryPublisher.LOTTO_PRICE + "개를 구매했습니다.");
    }

    private void printInputPurchaseAmountMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    private void printLottoNumber(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }
}
