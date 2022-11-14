package lotto.domain;

import lotto.utils.StringToListConverter;
import lotto.view.ProjectView;

public class LottoShop {
    private final Seller seller;
    private final ProjectView projectView;

    public LottoShop(Seller seller, ProjectView projectView) {
        this.seller = seller;
        this.projectView = projectView;
    }

    public void open(){
        String money = projectView.askPurchaseMoney();
        try {
            IssuedLotto issuedLotto = seller.sellLotto(money);
            projectView.sell(issuedLotto);

            String winningNumber = projectView.getWinningNumber();
            String bonusNumber = projectView.getBonusNumber();
            StringToListConverter converter = new StringToListConverter();
            LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(converter, winningNumber, bonusNumber);

            WinningResult result = lottoWinningNumber.getResult(issuedLotto);
            projectView.printResult(result, Integer.parseInt(money));
        } catch (IllegalArgumentException e) {
            projectView.printErrorMessage(e.getMessage());
        }
    }
}
