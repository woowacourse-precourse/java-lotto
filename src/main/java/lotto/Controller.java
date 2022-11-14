package lotto;

import java.util.List;

public class Controller {
    public void run() {
        List<Lotto> lottos = getLottos();
        WinningLotto winningLotto = getWinningLotto();
        getResult(lottos, winningLotto);
    }

    private List<Lotto> getLottos() {
        int lottoPrice = InputView.getLottoPrice();
        int lottoCount = LottoGame.getLottoCount(lottoPrice);

        OutputView.printLottoCount(lottoCount);

        List<Lotto> lottos = LottoGame.getLottos(lottoCount);

        OutputView.printLottos(lottos);

        return lottos;
    }

    private WinningLotto getWinningLotto() {
        String winningLottoNumber = InputView.getWinningLottoNumbers();
        String winningBonusNumber = InputView.getWinningBonusNumber(winningLottoNumber);

        return LottoGame.createWinningLotto(winningLottoNumber, winningBonusNumber);
    }

    private void getResult(List<Lotto> lottos, WinningLotto winningLotto) {
        for (Lotto lotto : lottos) {
            int matchCount = lotto.getCountOfMatch(winningLotto.getWinningLottoNumbers());
            boolean bonusMatch = lotto.containBonus(winningLotto.getBonusNumber());
            System.out.println(matchCount + " " + bonusMatch);
            System.out.println(LottoRank.valueOf(matchCount, bonusMatch));
        }
    }
}
