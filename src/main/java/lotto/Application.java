package lotto;

import lotto.domain.Answer;
import lotto.domain.Statistics;
import lotto.domain.Ticket;
import lotto.template.Input;
import lotto.template.Output;

import java.util.List;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        try {
            int money = Input.insertMoney();
            Ticket ticket = new Ticket(money);
            Output.showTicket(ticket);

            Answer answer = new Answer();
            List<Integer> winningNumbers = Input.insertWinningNumbers();
            answer.setWinningNumbers(winningNumbers);
            int bonusNumber = Input.insertBonusNumber();
            answer.setBonusNumber(bonusNumber);

            Statistics statistics = new Statistics(ticket, answer);
            Output.showWinningStatistics(statistics);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}