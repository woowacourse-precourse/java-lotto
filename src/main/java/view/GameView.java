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

    private final MoneyController moneyController = new MoneyController();
    private final UserLottoController userLottoController = new UserLottoController();
    private final LottoController lottoController = new LottoController();
    private final BonusController bonusController = new BonusController();
    private final RankInfoController rankInfoController = new RankInfoController();
    private final InputMessage inputMessage = new InputMessage();
    private final OutputMessage outputMessage = new OutputMessage();


    public void start() {
        Money money = moneyController.createMoney(inputMessage.inputPurchaseAmount());
        int purchaseNumber = moneyController.getAvailablePurchaseNumber(money);
        outputMessage.printNumberOfPurchase(purchaseNumber);

        UserLotto userLotto = userLottoController.createUserLotto(purchaseNumber);
        outputMessage.printPurchaseLotto(userLottoController.getUserLottoHistory(userLotto));

        Lotto lotto = lottoController.createLotto(inputMessage.inputWinningNumber());
        Bonus bonus = bonusController.createBonus(inputMessage.inputBonusNumber(), lotto);

        RankInfo rankInfo = rankInfoController.createRankInfo();
        rankInfo = rankInfoController.getRankInfo(rankInfo, lotto, userLotto, bonus);
        outputMessage.printStatistic(rankInfo);
        outputMessage.printYield(rankInfoController.getYield(rankInfo, money));
    }
}