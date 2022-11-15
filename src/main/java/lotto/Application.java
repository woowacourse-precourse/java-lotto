package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;
import lotto.domain.Winning;
import lotto.service.LottoService;
import lotto.view.ResponseMessage;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            LottoService lottoService = new LottoService();

            ResponseMessage.printPurchaseMoney();
            Money buyMoney = new Money(Console.readLine());

            final int buyNumber = buyMoney.getMoney() / 1000;
            ResponseMessage.printLottoNumbers(buyNumber);

            lottoService.addLotteries(buyNumber);
            lottoService.printLotteries();

            ResponseMessage.printWinningNumbers();
            Winning winning = new Winning(Console.readLine());

            ResponseMessage.printBonusNumber();
            Winning bonus = new Winning(winning.getWinningNumbers(), Console.readLine());

            lottoService = new LottoService(
                    lottoService.getLotteries(),
                    winning.getWinningNumbers(),
                    bonus.getBonusNumber(),
                    buyMoney.getMoney()
            );

            ResponseMessage.printWinStatistics(lottoService.getMatches(), lottoService.getProfitRate());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
