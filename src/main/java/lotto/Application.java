package lotto;

import lotto.domain.Generator;
import lotto.domain.Purchase;
import lotto.domain.RaffleNumber;
import lotto.domain.Roulette;
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

        Roulette roulette = new Roulette(raffleNumber.winningNumber, raffleNumber.bonusNumber);
        roulette.setLottoStatus();
        for (Lotto one : myLotto) {
            int sameNumber = roulette.compareWithWinningNumber(one.getNumbers());
            if (sameNumber < 3) {
                continue;
            }
            roulette.countLotto(one.getNumbers(), sameNumber);
        }

        printer.printWinning(roulette.lottoStatus);
    }
}
