package lotto;

import java.util.ArrayList;
import java.util.Collections;
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

    public void printWinningStatistics(List<Rank> rankResult) {
        System.out.println("당첨 통계\n" +
                "---");
        LottoManager lottoManager = new LottoManager();
        int[] rankCount = lottoManager.getRankCount(rankResult);
        for (int i = 0; i < Rank.MAX_RANK; i++) {
            String message = Rank.RANK_ASC.get(i).getMessage();
            message += rankCount[i] + "개";
            System.out.println(message);
        }
        printYield(rankResult);
    }

    public void printYield(List<Rank> rankResult) {
        LottoManager lottoManager = new LottoManager();
        double winnings = lottoManager.getWinnings(rankResult);
        double payment = Lotto.PRICE * rankResult.size();
        double yield = winnings / payment * 100;
        System.out.println("총 수익률은 " + String.format("%.1f", yield) + "%입니다.");
    }

    public void printLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        Collections.sort(numbers);
        //numbers.sort(Comparator.naturalOrder());
        System.out.println(numbers);
    }
}
