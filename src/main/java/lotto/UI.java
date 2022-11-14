package lotto;

import java.util.List;

public class UI {

    public void printInputMoneyMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }
    public void printPurchaseHistory(Customer customer) {

    }

    public void printWinningStatistics() {

    }

    public void printLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        System.out.println(numbers);
    }
}
