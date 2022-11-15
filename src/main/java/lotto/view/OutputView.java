package lotto.view;

import lotto.enums.Announcement;
import lotto.model.Lotto;

import java.math.BigInteger;
import java.util.List;

public class OutputView {
    public void printErrorMessage(String message) {
        System.out.println(message);
    }
    public void announceInsertMoney() {
        Announcement.INSERT_MONEY.announce();
    }
    public void announceInputWinningNumbers() {
        Announcement.INPUT_WINNING_NUMBERS.announce();
    }
    public void announceInputBonusNumber() {
        Announcement.INPUT_BONUS_NUMBERS.announce();
    }

    public void announceNumberOfPurchases(BigInteger numberOfLottos) {
        Announcement.NUMBER_OF_PURCHASES.announce(numberOfLottos);
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
