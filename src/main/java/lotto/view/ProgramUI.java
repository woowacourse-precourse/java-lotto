package lotto.view;

import lotto.domain.Prize;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.view.Constants.*;

public class ProgramUI {
    public String inputMoney() {
        System.out.println(INPUT_MONEY);
        return readLine();
    }

    public void printTickets(int numOfTickets, List<List<Integer>> purchasedTickets) {
        String purchased = String.format(BOUGHT_NOTICE, numOfTickets);
        System.out.println();
        System.out.println(purchased);
        for (List<Integer> ticket: purchasedTickets) {
            System.out.println(ticket);
        }
    }

    public String inputWinningNumbers() {
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBERS);
        return readLine();
    }

    public String inputBonusNumber() {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER);
        return readLine();
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
}
