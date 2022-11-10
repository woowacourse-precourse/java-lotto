package lotto;

import static lotto.controller.LottoController.*;

import lotto.domain.Company;
import lotto.domain.Lotto;
import lotto.domain.LottoSeller;
import lotto.domain.PrizeMoney;
import lotto.domain.User;
import lotto.view.Input;
import lotto.view.Output;

public class Application {
    public static void main(String[] args) {
        Output.printNotice(Notice.start.getNoticeMessage());

        User user = new User(Integer.parseInt(Input.buyLotto()));

        LottoSeller seller = new LottoSeller(User.getMoney());

        Output.printResult(seller.getQuantity(), Notice.purchase.getNoticeMessage());

        user.userLottoeris(seller.getLotto());


        //당첨 번호 입력
        Output.printNotice(Notice.winningNumbers.getNoticeMessage());
        Lotto lotto = new Lotto(pickWinningNumbers());
        Output.printNotice(Notice.bonusNumber.getNoticeMessage());
        Company lottoCompany = new Company(lotto.getNumbers(), pickBonusNumbers());

        Output.printNotice(Notice.statistics.getNoticeMessage());


        PrizeMoney prizeMoney = new PrizeMoney();
        prizeMoney.setCount(countWinningLotto(user.getLottoeris(), lottoCompany.getWinningLotto(), lottoCompany.getBonus(), LottoSeller.getQuantity()));

        Output.printCount(prizeMoney.getCount());

        user.setRateOfReturn(calculateProfit(prizeMoney.getCount(), user.getMoney()));

        Output.printRateOfReturn(user.getRateOfReturn());
    }
}
