package lotto.domain.controller;

import lotto.domain.model.Bonus;
import lotto.domain.model.FirstPlace;
import lotto.domain.model.WinningLotto;
import lotto.domain.model.LottoResult;
import lotto.domain.model.Pay;
import lotto.domain.model.UserLotto;
import lotto.domain.view.OutputData;

public class LottoController {
    private Pay pay;
    private UserLotto userLotto;
    private FirstPlace firstPlace;
    private Bonus bonus;


    public void purchaseLotto(String pay) {
        this.pay = new Pay(pay);
        this.userLotto = new UserLotto(this.pay);
        OutputData.printUserLotto(this.userLotto, this.pay);
    }

    public void designateFirstPlace(String firstPlace) {
        this.firstPlace = new FirstPlace(firstPlace);
    }

    public void designateBonus(String bonus) {
        this.bonus = new Bonus(this.firstPlace, bonus);
    }

    public void calculateStatisticsByUserLotto() {
        LottoResult lottoResult = new LottoResult(this.userLotto, new WinningLotto(firstPlace, bonus));
        OutputData.printLottoResult(lottoResult, this.pay);
    }

}
