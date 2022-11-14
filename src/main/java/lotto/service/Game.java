package lotto.service;

import lotto.constant.LottoConstant;
import lotto.domain.Lotto;
import lotto.domain.Player;
import lotto.service.NumberGenerator;

import java.util.List;

public class Game {

    public Game() {
        play(new Player());
    }

    public void play(Player player) {
        try {
            NumberGenerator numberGenerator = new NumberGenerator();

            Announce.announceInputMessage();
            int purchasePrice = player.enterPurchasePrice();
            int purchaseQuantity = numberGenerator.calculatorLottoQuantity(purchasePrice);

            Announce.announcePurchaseMessage(purchaseQuantity);
            numberGenerator.createLottos(purchaseQuantity);
            numberGenerator.printLottos(numberGenerator.autoLotto);

            Announce.announceInputLottoNumbers();
            List<Integer> computerLotto = numberGenerator.addComputerNumber(player.enterLottoNumbers());
            Lotto lotto = new Lotto(computerLotto);

            Announce.announceInputBonusNumber();
            lotto.enterBonusNumber();

            Announce.announceWinningStatistics();
            lotto.processLotto(numberGenerator.autoLotto, purchasePrice);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
