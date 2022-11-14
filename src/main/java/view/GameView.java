package view;

import domain.Bonus.Bonus;
import domain.Bonus.BonusController;
import domain.Lotto.Lotto;
import domain.Lotto.LottoController;
import domain.Money.Money;
import domain.Money.MoneyController;
import domain.RankInfo.RankInfo;
import domain.RankInfo.RankInfoController;
import domain.UserLotto.UserLotto;
import domain.UserLotto.UserLottoController;

public class GameView {

    MoneyController moneyController = new MoneyController();
    UserLottoController userLottoController = new UserLottoController();
    LottoController lottoController = new LottoController();
    BonusController bonusController = new BonusController();
    RankInfoController rankInfoController = new RankInfoController();
    InputMessage inputMessage = new InputMessage();
    OutputMessage outputMessage = new OutputMessage();


    public void start() {
        Money money = moneyController.getPurchaseAmount(inputMessage.inputPurchaseAmount());
        int purchaseNumber = moneyController.getAvailablePurchaseNumber(money);
        outputMessage.printNumberOfPurchase(purchaseNumber);

        UserLotto userLotto = userLottoController.createUserLotto(purchaseNumber);
        outputMessage.printPurchaseLotto(userLottoController.getUserLottoHistory(userLotto));

        Lotto lotto = lottoController.createWinningNumber(inputMessage.inputWinningNumber());
        Bonus bonus = bonusController.createBonusNumber(inputMessage.inputBonusNumber(), lotto);

        RankInfo rankInfo = rankInfoController.createRankInfo();
        rankInfo = rankInfoController.getRankInfo(rankInfo, lotto, userLotto, bonus);
        outputMessage.printStatistic(rankInfo);
        outputMessage.printYield(rankInfoController.getYield(rankInfo, money));
    }
}