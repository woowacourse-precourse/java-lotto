package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.machine.Lotto;
import lotto.machine.Numbers;
import lotto.machine.Tickets;
import lotto.ui.Input;

public class Application {
    public static void main(String[] args) {
        try {
            String payment = Input.submitPayment();
            Integer purchasePrice = Convertor.toPurchasePrice(payment);

            Tickets tickets = new Tickets(purchasePrice);
            List<List<Integer>> lottoTickets = tickets.getTickets();
            Output.purchaseSuccessful(purchasePrice, lottoTickets);

            // Winner 클래스에 다시 넣어야 할 듯
            String winningNumbers = Input.submitWinningNumbers();
            List<Integer> winningNumbersConverted =  Convertor.separate(winningNumbers);
            String bonusNumber = Input.submitBonusNumber();
            Integer bonusNumberConverted = Convertor.getNumericValue(bonusNumber);
            Validator.checkIfBonusNumberIncludedInWinningNumbers(
                    winningNumbersConverted,
                    bonusNumberConverted
            );

            List<Integer> profits = new ArrayList<>();
            for (List<Integer> myLotto : lottoTickets) {
                Matcher matcher = new Matcher(
                        myLotto,
                        winningNumbersConverted,
                        bonusNumberConverted
                );
                Integer prizeMoney = Ranks.getPrizeMoneyBy(
                        matcher.getMatchingWinningNumberCount(),
                        matcher.getMatchingBonusNumberCount()
                );
                profits.add(prizeMoney);
            }

            Result matchingResult = new Result(profits);
            Output.statistics(purchasePrice, matchingResult.getStatistics());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }
}
