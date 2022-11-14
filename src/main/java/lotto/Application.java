package lotto;

import lotto.domain.*;
import lotto.utils.StringToIntConverter;
import lotto.view.ProjectView;

public class Application {
    public static void main(String[] args) {
        Seller seller = new Seller(new StringToIntConverter());
        ProjectView projectView = new ProjectView();

        LottoShop lottoShop = new LottoShop(seller, projectView);
        lottoShop.open();
    }
}
