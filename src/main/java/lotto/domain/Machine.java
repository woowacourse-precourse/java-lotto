package lotto.domain;

import lotto.view.InputView;

import java.util.List;

public class Machine {

    public void start() {
        int quantity = Convertor.getQuantity(InputView.amount());
        List<Lotto> lottos = LottoGenerator.getLottos(quantity);
        List<Integer> winningNumbers = Convertor.getNumbers(InputView.winningNumbers());
        int bonusNumber = Convertor.getNumber(InputView.bonusNumber());

        List<Rank> ranks = RankGenerator.getRanks();
        CompareLotto.compare(ranks, lottos, winningNumbers, bonusNumber);
    }


}
