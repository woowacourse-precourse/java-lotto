package lotto;

import java.util.List;

import static lotto.Lotto.*;

public class Application {
    public static void main(String[] args) {
        int money = read();
        if(money != 0){
            numOfTickets(money);
            List<List> tickets = purchased();
            printTickets(tickets);
            String winningIn = winInput();
            String bonusIn = bonusIn();
            List<Integer> winningNum = validateWin(winningIn,bonusIn);
            loop(winningNum, tickets);
        }
    }
}
