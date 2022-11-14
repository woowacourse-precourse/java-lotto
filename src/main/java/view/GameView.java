package view;

import controller.*;
import domain.*;

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

        // 몇 장의 로또를 발행할 것인지 계산
        int purchaseNumber = moneyController.getAvailablePurchaseNumber(money);
        outputMessage.printNumberOfPurchase(purchaseNumber);

        // 사용자에게 랜덤으로 로또 번호를 발행하고 출력한다
        UserLotto userLotto = userLottoController.createUserLotto(purchaseNumber);
        outputMessage.printPurchaseLotto(userLottoController.getUserLottoHistory(userLotto));

        // 당첨 번호와 보너스 번호를 입력 한다
        Lotto lotto = lottoController.createWinningNumber(inputMessage.inputWinningNumber());
        Bonus bonus = bonusController.createBonusNumber(inputMessage.inputBonusNumber(), lotto);

        // 당첨 통계를 출력한다
        RankInfo rankInfo = rankInfoController.createRankInfo();
        rankInfo = rankInfoController.getRankInfo(rankInfo, lotto, userLotto, bonus);
        outputMessage.printStatistic(rankInfo);
    }
}