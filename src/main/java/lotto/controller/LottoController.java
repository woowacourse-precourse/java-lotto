package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.model.AutoLottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {
    public LottoController() {
    }

    public void play() {
        Money money = getUserMoneyInput();
        List<Lotto> lottos = issueUserBoughtLotto(money.calculateBoughtLottoCount());
        WinningLotto winningLotto = issueWinningLotto();
    }

    private Money getUserMoneyInput() {
        return new Money(InputView.inputMoney());
    }

    private List<Lotto> issueUserBoughtLotto(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        generateAutoLotto(lottos, lottoCount);
        return lottos;
    }

    private List<Lotto> generateAutoLotto(List<Lotto> lottos, int lottoCount) {
        while (lottos.size() < lottoCount) {
            lottos.add(AutoLottoGenerator.objectLotto());
        }
        return lottos;
    }

    private List<List<Integer>> transferLottoToNumbers(List<Lotto> lottos) {
        return lottos.stream()
                .map(Lotto::getSortedNumbers)
                .collect(Collectors.toList());
    }

    private WinningLotto issueWinningLotto() {
        Lotto lotto = new Lotto(InputView.inputLottoNum());
        int bonusNumber = InputView.inputBonusNum();
        return new WinningLotto(lotto, bonusNumber);
    }
}
