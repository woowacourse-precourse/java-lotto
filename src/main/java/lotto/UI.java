package lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UI {
    public void printPurchaseHistory(Customer customer) {
        List<Lotto> purchaseHistory = customer.getLotteryTickets();
        int count = purchaseHistory.size();
        System.out.println(count + "개를 구매했습니다.");

        for (Lotto lotto : purchaseHistory) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            lottoNumbers.sort(Comparator.naturalOrder());
            System.out.println(lottoNumbers);
        }
    }

    public void printWinningStatistics() {

    }

    public void printLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        System.out.println(numbers);
    }
}
