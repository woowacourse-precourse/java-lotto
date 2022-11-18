package lotto.controller;

import lotto.domain.IssuedLotto;
import lotto.domain.LottoWinningNumber;
import lotto.domain.Seller;
import lotto.domain.WinningResult;
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
        try {
            String money = projectView.askPurchaseMoney();
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
