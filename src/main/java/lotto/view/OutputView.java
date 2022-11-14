package lotto.view;

import lotto.view.constant.PurchasePhrase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OutputView {
    static final String PURCHASE_PHRASE = PurchasePhrase.PURCHASE.getPhrase();
    static final String LOTTERY_NUMBER_PHRASE = PurchasePhrase.LOTTERY_NUMBER.getPhrase();

    public static void showPurchaseList(List<List<Integer>> lotteryTickets) {
        System.out.println(String.format(PURCHASE_PHRASE, lotteryTickets.size()));
        for (List<Integer> lotteryTicket : lotteryTickets) {
            showLotteryNumbers(lotteryTicket);
        }
    }

    private static void showLotteryNumbers (List<Integer> lotteryTicket) {
        List<Integer> lotteryNumbers = new ArrayList<>(lotteryTicket);
        Collections.sort(lotteryNumbers);
        System.out.println(String.format(LOTTERY_NUMBER_PHRASE, lotteryNumbers.toArray(new Integer[0])));
    }
}
