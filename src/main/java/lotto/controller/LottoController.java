package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.Buyer;
import lotto.Winning;
import lotto.service.LottoService;
import lotto.system.SystemMessage;
import lotto.system.SystemValid;
import lotto.type.ErrorType;
import lotto.type.Rank;

public class LottoController {
    private final LottoService lottoService = new LottoService();

    public void run() {
        try {
            Buyer buyer = buy();
            Winning winning = Pick();
            List<Rank> lottosRank = buyer.getLottosRank(winning.getNumbers(), winning.getBonusNumber());
            printHistory(lottosRank);
            printPortfolio(lottosRank, buyer.getPurchaseMoney());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    private Buyer buy() {
        SystemMessage.inputMoney();
        String input = Console.readLine();
        SystemValid.validateForNumber(input, ErrorType.MONEY);
        int money = Integer.parseInt(input);
        System.out.println();
        return lottoService.buy(money);
    }

    private Winning Pick() {
        return lottoService.pick(winningPick(), bonusPick());
    }

    private List<Integer> winningPick() {
        SystemMessage.inputWinningNumber();
        String input = Console.readLine();
        SystemValid.validateForWinningNumber(input);
        System.out.println();
        return lottoService.winningInputParseToList(input);
    }

    private int bonusPick() {
        SystemMessage.inputBonusNumber();
        String input = Console.readLine();
        SystemValid.validateForNumber(input, ErrorType.BONUS);
        System.out.println();
        return Integer.parseInt(input);
    }

    private void printHistory(List<Rank> lottosRank) {
        SystemMessage.winningHistory(lottosRank);
    }

    private void printPortfolio(List<Rank> lottosRank, int purchaseMoney) {
        double portfolio = lottoService.calculatePortfolio(lottosRank, purchaseMoney);
        SystemMessage.portfolio(portfolio);
    }
}
