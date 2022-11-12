package utils;

import lotto.Lotto;
import lotto.LottoCounter;
import org.mockito.internal.verification.NoMoreInteractions;
import statements.NormalStatements;

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

    public void showWinningRate(){
        System.out.println(NormalStatements.SHOW_WINNING_RATE_FORM.done());
        System.out.println(NormalStatements.SHOW_WINNING_RATE_FORM_LINE.done());
        System.out.println(NormalStatements.THREE_NUMBERS_MATCHED.done()
                +lottoCounter.threeMatchedTickets()
                +NormalStatements.COUNTING_UNIT.done());
        System.out.println(NormalStatements.FOUR_NUMBERS_MATCHED.done()
                +lottoCounter.fourMatchedTickets()
                +NormalStatements.COUNTING_UNIT.done());
        System.out.println(NormalStatements.FIVE_NUMBERS_MATCHED.done()
                +lottoCounter.fiveMatchedTickets()
                +NormalStatements.COUNTING_UNIT.done());
        System.out.println(NormalStatements.FIVE_NUMBERS_AND_BONUS_MATCHED.done()
                +lottoCounter.fiveAndBonusMatchedTickets()
                +NormalStatements.COUNTING_UNIT.done());
        System.out.println(NormalStatements.SIX_NUMBERS_MATCHED.done()
                +lottoCounter.sixMatchedTickets()
                +NormalStatements.COUNTING_UNIT.done());
        System.out.printf(NormalStatements.SHOW_WINNING_RATE1
                +"%f"
                +NormalStatements.SHOW_WINNING_RATE2,
                lottoCounter.winningRate());
    }
}
