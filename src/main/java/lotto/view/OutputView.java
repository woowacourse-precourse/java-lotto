package lotto.view;

import lotto.enums.Announcement;
import lotto.enums.PrizeOfLotto;
import lotto.enums.Profit;
import lotto.model.Lotto;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

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

    public void printResultOfLottos(Map<String, Integer> resultOfLottos, double ratio) {
        Announcement.STATICS_OF_LOTTOS.announce();
        for (PrizeOfLotto rank : PrizeOfLotto.values()) {
            rank.announce(resultOfLottos);
        }
        Profit.RATIO_OF_WINNING_TO_INSERT_MONEY.announce(ratio);
    }
}
