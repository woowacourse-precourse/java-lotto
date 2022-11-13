package lotto;

import utils.ConsoleUserInput;
import utils.ConsoleUserOutput;

import java.util.List;

public class Application {
    public static ConsoleUserInput in = new ConsoleUserInput();
    public static ConsoleUserOutput out = new ConsoleUserOutput();
    public static void main(String[] args) {
        int theNumberOfTickets;
        List<Integer> winningNumbers;
        List<List<Integer>> lottoNumbersOnTickets;

        out.askHowMuchWouldYouPayForLottos();
        theNumberOfTickets=LottoTicketing.countTheNumberOfTickets(in.inputMoneyForLottos());
        out.insertBlankLine();

        out.tellNumberOfLottosUserBought(theNumberOfTickets);
        lottoNumbersOnTickets = LottoTicketing.giveLottoTickets(theNumberOfTickets);
        for(int lottoSheet=1; lottoSheet<=theNumberOfTickets; lottoSheet++) {
            lottoNumbersOnTickets.get(lottoSheet);
        }
        out.insertBlankLine();

        out.askWinningNumbers();
        winningNumbers=in.toIntegerNumbersWithoutComma(in.inputWinningNumbers());
        System.out.println(winningNumbers);
        out.insertBlankLine();

        out.askBonusNumber();
        in.inputBonusNumber();
        out.insertBlankLine();

        out.showWinningRate();

    }
}
