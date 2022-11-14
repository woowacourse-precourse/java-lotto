package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.Model.Lotto;
import lotto.Model.Purchase;
import lotto.Model.User;
import lotto.Model.WinningLotto;
import lotto.domain.LottoChecker;
import lotto.domain.LottoGenerator;
import lotto.domain.WinningCount;

public class Controller {
    private Purchase purchase;
    private User user;
    private LottoGenerator lottoGenerator;
    private WinningLotto winningLotto;
    private WinningCount winningCount;
    private LottoChecker lottoChecker;

    public Controller() {
        ;
        purchase = new Purchase();
        user = new User();
        lottoGenerator = new LottoGenerator();
        winningLotto = new WinningLotto();
        winningCount = new WinningCount();
        lottoChecker = new LottoChecker();
    }

    public void buyLotto() throws IllegalArgumentException {
        System.out.println(Constant.ASK_PRICE);
        String money = Console.readLine();
        purchase.setPrice(money);

        user.setPrice(purchase.getPrice());
        user.setUserLotto(lottoGenerator.generateLottoBundle(user.getPrice()));
        user.showUserLottoBundle();
    }

    public void inputNumber() {
        System.out.println(Constant.ASK_WINNING_NUMBER);
        winningLotto.askWinningNumber();
        winningLotto.askBonusNumber();
    }

    public void winningStatics() {
        checkWinning();
        showWinCase(winningCount);
        showProfitRate(lottoChecker.profitRate(purchase.getPrice(), winningCount.getProfitSum()));
    }

    private void checkWinning() {
        for (Lotto userLotto : user.getUserLotto()) {
            int lottoResult = lottoChecker.lottoCompare(userLotto, winningLotto);
            winningCount.addWinningResult(Integer.toString(lottoResult), lottoChecker.bonusCompare(userLotto, winningLotto));
        }
    }

    private void showWinCase(WinningCount winningCount) {
        System.out.println(Constant.WINNING_STATS);
        System.out.println("---");
        System.out.println(Constant.THREE_MATCH + winningCount.getCount().get(Constant.FIFTH_PLACE) + Constant.PIECE);
        System.out.println(Constant.FOUR_MATCH + winningCount.getCount().get(Constant.FOURTH_PLACE) + Constant.PIECE);
        System.out.println(Constant.FIVE_MATCH + winningCount.getCount().get(Constant.THIRD_PLACE) + Constant.PIECE);
        System.out.println(Constant.FIVE_BONUS_MATCH + winningCount.getCount().get(Constant.SECOND_PLACE) + Constant.PIECE);
        System.out.println(Constant.SIX_MATCH + winningCount.getCount().get(Constant.FIRST_PLACE) + Constant.PIECE);
    }

    private void showProfitRate(double rate) {
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }
}
