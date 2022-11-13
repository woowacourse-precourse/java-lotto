package lotto;

import lotto.domain.*;
import lotto.view.ProjectView;

public class Application {
    public static void main(String[] args) {
        Seller seller = Seller.getInstance();
        ProjectView projectView = new ProjectView();

        LottoShop lottoShop = new LottoShop(seller, projectView);
        lottoShop.open();
    }
}
