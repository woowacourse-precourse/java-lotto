package lotto.view;

import lotto.domain.Rank;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static lotto.view.Constants.TOTAL_WIN_STAT;

public class OutputView {
    final String BOUGHT_NOTICE = "%d개를 구매했습니다.";
    final String WIN_STAT = "당첨 통계\n---";
    final String EARNED_RATE = "총 수익률은 %.1f%%입니다.";

    final String INPUT_MONEY = "구입 금액을 입력해 주세요.";
    final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public void printInputMoney() {
        System.out.println(INPUT_MONEY);
    }

    public void printInputWinningNumbers() {
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBERS);
    }

    public void printInputBonusNumber() {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER);
    }

    public void printTickets(int numOfTickets, List<List<Integer>> purchasedTickets) {
        String purchased = String.format(BOUGHT_NOTICE, numOfTickets);
        System.out.println();
        System.out.println(purchased);
        for (List<Integer> ticket: purchasedTickets) {
            System.out.println(ticket);
        }
    }

    public void printPrize(LinkedHashMap<Rank, Integer> winningTickets) {
        List<Integer> winningCount = new ArrayList<>(winningTickets.values());

        System.out.println();
        System.out.println(WIN_STAT);
        String notice = String.format(TOTAL_WIN_STAT, winningCount.toArray());
        System.out.println(notice);
    }

    public void printRate(float earnedRate) {
        String rateNotice = String.format(EARNED_RATE, earnedRate);
        System.out.println(rateNotice);
    }
}
