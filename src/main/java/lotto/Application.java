package lotto;

import lotto.domain.IssuedLotto;
import lotto.domain.Seller;
import lotto.view.ProjectView;

public class Application {
    public static void main(String[] args) {
        String money = ProjectView.askPurchaseMoney();

        Seller seller = Seller.getInstance();
        IssuedLotto issuedLotto = seller.sellLotto(money);
        ProjectView.sell(issuedLotto);
    }
}
