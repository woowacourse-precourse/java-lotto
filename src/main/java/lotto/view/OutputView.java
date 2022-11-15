package lotto.view;

import lotto.enums.Announcement;

public class OutputView {
    public void printErrorMessage(String message) {
        System.out.println(message);
    }
    public void announceInsertMoney() {
        Announcement.INSERT_MONEY.announce();
    }

}
