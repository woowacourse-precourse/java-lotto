package utils;

import lotto.Lotto;
import lotto.LottoCounter;
import org.mockito.internal.verification.NoMoreInteractions;
import statements.NormalStatements;

import java.util.List;

public class ConsoleUserOutput {
    LottoCounter lottoCounter = new LottoCounter();
    public static void insertBlankLine(){
        System.out.println();
    }

    public static void askHowMuchWouldYouPayForLottos(){
        System.out.println(NormalStatements.ASK_MONEY_TO_BUY_LOTTO.done());
    }

    public static void tellNumberOfLottosUserBought(int theNumberOfLottos){
        System.out.println(theNumberOfLottos+NormalStatements.LET_USER_KNOW_THE_NUMBER_OF_TICKETS.done());
    }

    public static void askWinningNumbers(){
        System.out.println(NormalStatements.ASK_WINNING_NUMBERS.done());
    }

    public static void askBonusNumber(){
        System.out.println(NormalStatements.ASK_BONUS_NUMBER.done());
    }

    public void showResultForm() {
        System.out.println(NormalStatements.SHOW_WINNING_RATE_FORM.done());
        System.out.println(NormalStatements.SHOW_WINNING_RATE_FORM_LINE.done());
    }

    public void showTheNumberOfThreeMatchedTickets(List<Integer> ticketNumbers, List<Integer> winningNumbers) {
        System.out.println(NormalStatements.THREE_NUMBERS_MATCHED.done()
                + lottoCounter.threeMatchedTickets(ticketNumbers, winningNumbers)
                + NormalStatements.COUNTING_UNIT.done());
    }
    public void showTheNumberOfFourMatchedTickets(List<Integer> ticketNumbers, List<Integer> winningNumbers) {
        System.out.println(NormalStatements.FOUR_NUMBERS_MATCHED.done()
                + lottoCounter.fourMatchedTickets(ticketNumbers, winningNumbers)
                + NormalStatements.COUNTING_UNIT.done());
    }
    public void showTheNumberOfFiveMatchedTickets(List<Integer> ticketNumbers, List<Integer> winningNumbers) {
        System.out.println(NormalStatements.FIVE_NUMBERS_MATCHED.done()
                + lottoCounter.fiveMatchedTickets(ticketNumbers, winningNumbers)
                + NormalStatements.COUNTING_UNIT.done());
    }

    public void showTheNumberOfFiveAndBonusMatchedTickets(List<Integer> ticketNumbers, List<Integer> winningNumbers
            ,int bonus) {

        System.out.println(NormalStatements.FIVE_NUMBERS_AND_BONUS_MATCHED.done()
                + lottoCounter.fiveAndBonusMatchedTickets(ticketNumbers, winningNumbers, bonus)
                + NormalStatements.COUNTING_UNIT.done());
    }

    public void showTheNumberOfSixMatchedTickets(List<Integer> ticketNumbers, List<Integer> winningNumbers) {
        System.out.println(NormalStatements.SIX_NUMBERS_MATCHED.done()
                + lottoCounter.sixMatchedTickets(ticketNumbers, winningNumbers)
                + NormalStatements.COUNTING_UNIT.done());
    }

    /*public void showLottoYield(List<Integer> ticketNumbers, List<Integer> winningNumbers) {
        System.out.printf(NormalStatements.SHOW_WINNING_RATE1
                        + "%f"
                        + NormalStatements.SHOW_WINNING_RATE2,
                lottoCounter.countLottoYield());
    }*/
}

