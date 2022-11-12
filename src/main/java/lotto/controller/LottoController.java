package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.util.AutoLottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public LottoController() {
    }

    public void play() {
        List<Lotto> lottos = issueUserBoughtLotto();
        showIssuedLottos(lottos);
        WinningLotto winningLotto = issueWinningLotto();
    }

    private List<Lotto> issueUserBoughtLotto() {
        Money money = new Money(InputView.requestMoneyInput());
        return generateAutoLotto(money.calculateBoughtLottoCount());
    }

    private List<Lotto> generateAutoLotto(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        while (lottos.size() < lottoCount) {
            lottos.add(AutoLottoGenerator.issueAutoLotto());
        }
        return lottos;
    }

    private void showIssuedLottos(List<Lotto> lottos) {
        OutputView.printIssuedLotto(transferLottoToNumbers(lottos));
    }

    private List<List<Integer>> transferLottoToNumbers(List<Lotto> lottos) {
        return lottos.stream()
                .map(Lotto::getSortedNumbers)
                .collect(Collectors.toList());
    }

    private WinningLotto issueWinningLotto() {
        Lotto lotto = new Lotto(InputView.requestWinningNumber());
        int bonusNumber = InputView.requestBonusNumber();
        return new WinningLotto(lotto, bonusNumber);
    }

}
