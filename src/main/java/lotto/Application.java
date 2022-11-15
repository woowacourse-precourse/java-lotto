package lotto;

import java.util.List;

import static lotto.Lotto.*;

public class Application {
    public static void main(String[] args) {
        int money = read();
        numOfTickets(money);
        List<List> tickets = purchased();
        printTickets(tickets);
        List<String> winningIn = winInput();
        List<Integer> winningNum = validateWin(winningIn);
        loop(winningNum, tickets);
    }
}
