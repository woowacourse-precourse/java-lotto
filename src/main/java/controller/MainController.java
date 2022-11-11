package controller;

import java.util.ArrayList;
import java.util.List;
import model.Lotto;
import model.Purchase;
import model.User;
import view.PrintView;
import view.ReceiveView;

public class MainController {

    public void run(){
        Purchase usersPurchase = purchaseLotto();
        User user = purchaseInfo(usersPurchase);

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
}
