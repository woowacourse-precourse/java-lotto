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
        Output.printNotice(Notice.START.getNoticeMessage());

        String money = Input.buyLotto();
        int checkMoney = 0;

        try {
            checkMoney = Integer.parseInt(money);
        } catch (IllegalArgumentException e) {
            Output.printNotice(Notice.ERROR.getNoticeMessage());
        }

        if (checkMoney != 0) {
            User user = new User(checkMoney);

            LottoSeller seller = new LottoSeller(User.getMoney());

            Output.printResult(seller.getQuantity(), Notice.PURCHASE.getNoticeMessage());

            user.userLottoeris(seller.getLotto());


            //당첨 번호 입력
            Output.printNotice(Notice.WINNING_NUMBERS.getNoticeMessage());
            Lotto lotto = new Lotto(pickWinningNumbers());
            Output.printNotice(Notice.BONUS_NUMBER.getNoticeMessage());
            Company lottoCompany = new Company(lotto.getNumbers(), pickBonusNumbers());

            Output.printNotice(Notice.STATISTICS.getNoticeMessage());


            PrizeMoney prizeMoney = new PrizeMoney();
            prizeMoney.setCount(getWinningRanking(user.getLottoeris(), lottoCompany.getWinningLotto(), lottoCompany.getBonus()));

            Output.printCount(prizeMoney.getCount());

            user.setRateOfReturn(calculateProfit(prizeMoney.getCount(), user.getMoney()));

            Output.printRateOfReturn(user.getRateOfReturn());
        }
    }
}
