package lotto;

import java.util.ArrayList;
import java.util.List;

public class UI {

    public void printInputMoneyMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }
    public void printPurchaseHistory(Customer customer) {
        List<Lotto> purchaseHistory = customer.getLotteryTickets();
        for (Lotto lotto : purchaseHistory) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinningStatistics() {

    }

    public void printLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        System.out.println(numbers);
    }
}
