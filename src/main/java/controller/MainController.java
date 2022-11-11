package controller;

import java.util.ArrayList;
import java.util.List;
import model.Lotto;
import model.Purchase;
import model.User;
import model.WinLotto;
import view.PrintView;
import view.ReceiveView;

public class MainController {

    public void run(){
        try {
            Purchase usersPurchase = purchaseLotto();
            User user = purchaseInfo(usersPurchase);
            WinLotto winLotto = winLottoWithBonus();
        } catch (IllegalArgumentException exception) {
            PrintView.error(exception.getMessage());
        }

    }

    private Purchase purchaseLotto() {
        PrintView.purchaseLotto();
        int purchaseLottoMoney = ReceiveView.purchaseLotto();
        Purchase purchase = new Purchase(purchaseLottoMoney);
        return purchase;
    }

    private User purchaseInfo(Purchase purchase){
        User user = makeUserToPurchase(purchase);
        PrintView.infoBoughtLotto(user);
        return user;
    }

    private User makeUserToPurchase(Purchase purchase) {
        int purchaseMoney = purchase.getMoney();
        int purchaseCount = purchaseMoney / Lotto.PER_PRICE_LOTTO;

        List<Lotto> boughtLotto = new ArrayList<>();
        for (int count = 0; count < purchaseCount; count += 1) {
            List<Integer> generateLotto = Lotto.generateLotto();
            boughtLotto.add(new Lotto(generateLotto));
        }

        return new User(boughtLotto,purchase);
    }

    public WinLotto winLottoWithBonus() {
        List<Integer> winLottoNumbers = getWinLotto();
        int bonusNumber = getBonusNumber();
        return new WinLotto(winLottoNumbers, bonusNumber);
    }

    private int getBonusNumber() {
        PrintView.bonusNum();
        int bonusNumber = ReceiveView.bonusNumber();
        return bonusNumber;
    }

    private List<Integer> getWinLotto() {
        PrintView.winNum();
        List<Integer> winLotto = ReceiveView.winLotto();
        return winLotto;
    }
}
