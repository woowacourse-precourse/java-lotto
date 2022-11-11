package lotto.view;

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
}
