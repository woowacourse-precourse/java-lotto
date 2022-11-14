package lotto;

import lotto.io.View;
import lotto.model.Amount;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.WinnerLotto;
import lotto.model.LottoResult;

import java.util.List;
import java.util.Map;

public class LottoProgram {
    private final View view;
    private final LottoService lottoService;

    public LottoProgram(View view, LottoService lottoService) {
        this.view = view;
        this.lottoService = lottoService;
    }

    public void run() {
        try {
            Amount amount = new Amount(getAmount());
            List<Lotto> createdLotto = lottoService.create(amount);
            view.showLotto(createdLotto);

            WinnerLotto winnerLotto = new WinnerLotto(getNumbers(), getBonus());

            Map<LottoRank, Integer> rank = lottoService.compare(createdLotto, winnerLotto);
            LottoResult lottoResult = new LottoResult(rank);

            view.showResult(lottoResult);
        } catch (IllegalArgumentException e) {
            view.printError(e.getMessage());
        }
    }

    private String getAmount() {
        view.requestAmount();
        return view.getInput();
    }

    private String getNumbers() {
        view.requestNumbers();
        return view.getInput();
    }

    private String getBonus() {
        view.requestBonus();
        return view.getInput();
    }
}

