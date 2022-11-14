package lotto;

import java.util.List;

public class UI {
    public void printPurchaseHistory(Customer customer) {

    }

    public void printWinningStatistics() {

    }

    public void printLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        System.out.println(numbers);
    }
}
