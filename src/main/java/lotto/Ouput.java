package lotto;

import java.util.Comparator;
import java.util.List;

public class Ouput {

    public void printPurchaseHistory(Customer customer) {
        List<Lotto> purchaseHistory = customer.getLottoTickets();
        int count = purchaseHistory.size();
        System.out.println(count + "개를 구매했습니다.");

        for (Lotto lotto : purchaseHistory) {
            printLotto(lotto);
        }
    }

    public void printWinningStatistics() {

    }

    public void printReturnRate() {

    }

    public void printLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        numbers.sort(Comparator.naturalOrder());
        System.out.println(numbers);
    }
}
