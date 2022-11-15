package lotto.game;

import static lotto.util.Constant.*;

import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;
import lotto.domain.Result;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {

    private LottoGenerator lottoGenerator;
    private Result result;

    public LottoGame() {
        lottoGenerator = new LottoGenerator();
        result = new Result();
    }

    // 게임 오류 발생시 오류를 처리하는 기능
    public void run() {
        try {
            playgame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // 게임을 실행하는 기능
    private void playgame() {
        int money = InputView.purchaseMoney();

        Lottos perchaseLottos = makePerchaseLotto(lottoCount(money));
        OutputView.printPerchasedLottoNumber(money, perchaseLottos);

        Lotto winningLotto = makeWinningLotto(InputView.winningNumberInput());
        Bonus bonus = makeBonus(winningLotto.getNumbers(), InputView.bounusNumberInput());

        result.matchLottoAndWinningLotto(perchaseLottos, winningLotto, bonus);
        OutputView.printWinningStats(result);

        OutputView.printYield(result, money);
    }

    // 로또 구입 개수를 구하는 기능
    private int lottoCount(int money) {
        return money / LOTTO_PURCHASE_COST;
    }

    // 구매된 로또들을 생성하는 기능
    private Lottos makePerchaseLotto(int count) {
        Lottos purchasedLottos = new Lottos();
        for (int lottoCount = 1; lottoCount <= count; lottoCount++) {
            Lotto lotto = new Lotto(lottoGenerator.createLotto());
            purchasedLottos.addLotto(lotto);
        }
        return purchasedLottos;
    }

    // 당첨 번호를 만드는 기능
    private Lotto makeWinningLotto(List<Integer> lottoNumber) {
        return new Lotto(lottoNumber);
    }

    // 보너스 번호를 만드는 기능
    private Bonus makeBonus(List<Integer> winningLotto, int bonus) {
        return new Bonus(winningLotto, bonus);
    }
}
