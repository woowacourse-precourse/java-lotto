package lotto;

import statements.ErrorStatements;
import utils.ConsoleUserInput;
import utils.ConsoleUserOutput;
import utils.Validator;

import java.util.List;

public class Application {
    public static ConsoleUserInput in = new ConsoleUserInput();
    public static ConsoleUserOutput out = new ConsoleUserOutput();
    public static void main(String[] args) {
        int theNumberOfTickets;
        int bonusNumber;
        float principal=0;
        List<Integer> winningNumbers;
        List<List<Integer>> lottoNumbersOnTickets;
        LottoCounter lottoCounter = new LottoCounter();

        try {
            out.askHowMuchWouldYouPayForLottos();
            theNumberOfTickets = LottoTicketing.countTheNumberOfTickets(in.inputMoneyForLottos());
            principal = theNumberOfTickets * 1000;
            out.insertBlankLine();

            out.tellNumberOfLottosUserBought(theNumberOfTickets);
            lottoNumbersOnTickets = LottoTicketing.giveLottoTickets(theNumberOfTickets);
            for (int lottoSheet = 0; lottoSheet < theNumberOfTickets; lottoSheet++) {
                System.out.println(lottoNumbersOnTickets.get(lottoSheet));
            }
            out.insertBlankLine();

            out.askWinningNumbers();
            winningNumbers = in.toIntegerNumbersWithoutComma(in.inputWinningNumbers());
            out.insertBlankLine();

            out.askBonusNumber();
            bonusNumber = in.inputBonusNumber(winningNumbers);
            out.insertBlankLine();

        for(int lottosheet=0; lottosheet<theNumberOfTickets; lottosheet++) {
            lottoCounter.countHowManyNumbersMatched(lottoNumbersOnTickets.get(lottosheet), winningNumbers,bonusNumber);
        }

        out.showResultForm();
        out.showTheNumberOfThreeMatchedTickets(lottoCounter.threeMatchedTickets());
        out.showTheNumberOfFourMatchedTickets(lottoCounter.fourMatchedTickets());
        out.showTheNumberOfFiveMatchedTickets(lottoCounter.fiveMatchedTickets());
        out.showTheNumberOfFiveAndBonusMatchedTickets(lottoCounter.fiveAndBonusMatchedTickets());
        out.showTheNumberOfSixMatchedTickets(lottoCounter.sixMatchedTickets());
        out.showLottoYield(principal, lottoCounter.addAllPrizeMoney());
        }catch (IllegalArgumentException exit){
            System.out.println(ErrorStatements.SHOUT_INVALID_FORMAT_ERROR.alarmed());
            System.out.println(ErrorStatements.EXIT_PROGRAM.alarmed());
        }
    }
}
