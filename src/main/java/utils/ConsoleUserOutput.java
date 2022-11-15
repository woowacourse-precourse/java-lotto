package utils;


import lotto.LottoCounter;
import statements.NormalStatements;

public class ConsoleUserOutput {
    LottoCounter lottoCounter = new LottoCounter();
    public void insertBlankLine(){
        System.out.println();
    }

    public void askHowMuchWouldYouPayForLottos(){
        System.out.println(NormalStatements.ASK_MONEY_TO_BUY_LOTTO.done());
    }

    public void tellNumberOfLottosUserBought(int theNumberOfLottos){
        System.out.println(theNumberOfLottos+NormalStatements.LET_USER_KNOW_THE_NUMBER_OF_TICKETS.done());
    }

    public void askWinningNumbers(){
        System.out.println(NormalStatements.ASK_WINNING_NUMBERS.done());
    }

    public void askBonusNumber(){
        System.out.println(NormalStatements.ASK_BONUS_NUMBER.done());
    }

    public void showResultForm() {
        System.out.println(NormalStatements.SHOW_WINNING_RATE_FORM.done());
        System.out.println(NormalStatements.SHOW_WINNING_RATE_FORM_LINE.done());
    }

    public void showTheNumberOfThreeMatchedTickets(int threeMatched) {
        System.out.println(NormalStatements.THREE_NUMBERS_MATCHED.done()
                + threeMatched
                + NormalStatements.COUNTING_UNIT.done());
    }
    public void showTheNumberOfFourMatchedTickets(int fourMatched) {
        System.out.println(NormalStatements.FOUR_NUMBERS_MATCHED.done()
                + fourMatched
                + NormalStatements.COUNTING_UNIT.done());
    }
    public void showTheNumberOfFiveMatchedTickets(int fiveMatched) {
        System.out.println(NormalStatements.FIVE_NUMBERS_MATCHED.done()
                + fiveMatched
                + NormalStatements.COUNTING_UNIT.done());
    }

    public void showTheNumberOfFiveAndBonusMatchedTickets(int fiveAndBonusMatched) {
        System.out.println(NormalStatements.FIVE_NUMBERS_AND_BONUS_MATCHED.done()
                + fiveAndBonusMatched
                + NormalStatements.COUNTING_UNIT.done());
    }

    public void showTheNumberOfSixMatchedTickets(int sixMatched) {
        System.out.println(NormalStatements.SIX_NUMBERS_MATCHED.done()
                + sixMatched
                + NormalStatements.COUNTING_UNIT.done());
    }

    public void showLottoYield(float principal, float prizeMoney) {
        System.out.println(NormalStatements.SHOW_WINNING_RATE1.done()
                        + lottoCounter.calculateLottoYield(principal, prizeMoney)
                        + NormalStatements.SHOW_WINNING_RATE2.done());
    }
}

