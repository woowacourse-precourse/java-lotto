package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.User;
import lotto.domain.WinningLotto;

import java.util.List;

public class Application {
    public static void printLotteries(List<Lotto> lotteries) {
        for (Lotto lotto : lotteries) {
            System.out.println(lotto.toString());
        }
    }

    public static void main(String[] args) {
        try {
            User user = new User();

            System.out.println("구입금액을 입력해 주세요.");
            user.receiveCostInput();
            int lottoCost = user.getLottoCost();

            LottoGame lottoGame = new LottoGame();
            int lottoNumber = lottoGame.countLotto(lottoCost);
            System.out.println("\n" + lottoNumber + "개를 구매했습니다.");

            lottoGame.createRandomLotto();
            List<Lotto> lotteries = lottoGame.getLotteries();
            printLotteries(lotteries);

            WinningLotto winningLotto = new WinningLotto();
            System.out.println("\n당첨 번호를 입력해 주세요.");
            winningLotto.receiveWinningNumber();

            System.out.println("\n보너스 번호를 입력해 주세요.");
            winningLotto.receiveBonusNumber();

            System.out.println("\n당첨 통계\n" +
                    "---");
            lottoGame.compareEachLotto(winningLotto);
            lottoGame.setRateOfReturn();
            System.out.println(lottoGame.rankCountResult());
            System.out.println(lottoGame.profitRateResult());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
