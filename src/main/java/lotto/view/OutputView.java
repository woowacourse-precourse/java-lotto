package lotto.view;

import lotto.domain.Prize;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static lotto.view.Constants.*;

public class OutputView {
    public void printTickets(int numOfTickets, List<List<Integer>> purchasedTickets) {
        String purchased = String.format(BOUGHT_NOTICE, numOfTickets);
        System.out.println();
        System.out.println(purchased);
        for (List<Integer> ticket: purchasedTickets) {
            System.out.println(ticket);
        }
    }

    public void printPrize(LinkedHashMap<Prize, Integer> winningTickets) {
        List<String> winningNotice = Prize.getNoticeValues();
        List<Integer> winningCount = new ArrayList<>(winningTickets.values());

        System.out.println();
        System.out.println(WIN_STAT);
        for (int i = 0; i < winningCount.size(); i++) {
            String notice = String.format(winningNotice.get(i), winningCount.get(i));
            System.out.println(notice);
        }
    }

    public void printRate(float earnedRate) {
        String rateNotice = String.format(EARNED_RATE, earnedRate);
        System.out.println(rateNotice);
    }
}
