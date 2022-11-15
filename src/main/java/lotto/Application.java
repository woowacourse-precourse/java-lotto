package lotto;

import lotto.domain.Generator;
import lotto.domain.Purchase;
import lotto.domain.RaffleNumber;
import lotto.domain.Revenue;
import lotto.domain.LottoComparator;
import lotto.ui.Printer;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Purchase purchase = new Purchase();
        purchase.inputMoney();
        int amountOfLotto = purchase.canBuyLotto(purchase.money);

        Generator generator = new Generator();
        List<Lotto> myLotto = generator.createLottoList(amountOfLotto);

        Printer printer = new Printer();
        printer.printLotto(amountOfLotto, myLotto);

        RaffleNumber raffleNumber = new RaffleNumber();
        raffleNumber.inputWinningNumber();
        raffleNumber.inputBonusNumber();

        LottoComparator lottoComparator = new LottoComparator(raffleNumber.winningNumber, raffleNumber.bonusNumber);
        lottoComparator.runComparator(myLotto);
        printer.printWinning(lottoComparator.lottoStatus);

        Revenue revenue = new Revenue(lottoComparator.lottoStatus);
        printer.printRevenue(revenue.calculateRevenue(purchase.money));
    }
}
