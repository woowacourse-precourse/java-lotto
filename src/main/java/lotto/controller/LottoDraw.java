package lotto.controller;

import lotto.model.LottoCompany;
import lotto.view.DrawOutputView;
import lotto.view.InputView;

public class LottoDraw {
    private LottoCompany lottoCompany;

    public LottoDraw(LottoCompany lottoCompany) {
        this.lottoCompany = lottoCompany;
    }

    public void draw() {
        DrawOutputView.guideDrawWinningNumbers();
        lottoCompany.setWinningLotto(InputView.input());
        DrawOutputView.guideDrawBonusNumber();
        lottoCompany.setBonusNumber(InputView.input());
    }
}
