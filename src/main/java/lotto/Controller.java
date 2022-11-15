package lotto;

import lotto.Model.Bonus;
import lotto.Model.Lotto;
import lotto.Model.Winning;
import lotto.Model.Result;
import lotto.Model.Price;
import lotto.Model.User;
import lotto.View.Data;

public class Controller {
    private Price price;
    private User user;
    private Lotto first;
    private Bonus bonus;


    public void purchaseLotto(final String pay) {
        this.price = new Price(pay);
        this.user = new User(this.price);
        Data.printUser(this.user, this.price);
    }

    public void FirstPlace(final String firstPlace) {
        this.first = new Lotto(firstPlace);
    }

    public void Bonus(final String bonus) {
        this.bonus = new Bonus(this.first, bonus);
    }

    public void calRateUser() {
        Result lottoResult = new Result(this.user, new Winning(first, bonus));
        Data.printResult(lottoResult, this.price);
    }

}