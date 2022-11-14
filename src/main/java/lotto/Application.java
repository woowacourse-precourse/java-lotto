package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.User;
import lotto.domain.WinningLotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        User user = new User();

        System.out.println("구입금액을 입력해 주세요.");
        int lottoCost = user.receiveInput();
        if (lottoCost % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로 입력해야 합니다.");
        }

        LottoGame lottoGame = new LottoGame();
        int lottoNumber = lottoGame.countLotto(lottoCost);
        System.out.println(lottoNumber+"개를 구매했습니다.");

        List<Lotto> lotteries = lottoGame.createRandomLotto();
        for (Lotto lotto:lotteries) {
            System.out.println(lotto.toString());
        }

        WinningLotto winningLotto = new WinningLotto();
        System.out.println("당첨 번호를 입력해 주세요.");
        winningLotto.receiveWinningNumber();

        System.out.println("보너스 번호를 입력해 주세요.");
        winningLotto.receiveBonusNumber();

        System.out.println("당첨 통계\n" +
                "---");
        lottoGame.compareEachLotto(winningLotto);
        lottoGame.setRateOfReturn();
        System.out.println(lottoGame);
    }
}
