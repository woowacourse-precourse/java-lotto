package lotto;

import java.util.List;
import lotto.domain.Money;
import lotto.service.LottoService;
import lotto.view.LottoDto;
import lotto.domain.LottoInput;
import lotto.view.PrizeDto;
import lotto.view.View;

public class LottoGame {
    private final View view;
    private final LottoService lottoService;

    public LottoGame(View view, LottoService lottoService) {
        this.view = view;
        this.lottoService = lottoService;
    }

    public void start() {
        try {
            LottoInput lottoInput = getLottoInput();
            PrizeDto prizeDto = lottoService.calcWinningResult(lottoInput);
            view.printPrize(prizeDto);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public LottoInput getLottoInput() {

        Money money = Money.of(view.inputMoney());
        LottoDto lottoDto = lottoService.createLottos(money);
        view.printBuyLotto(lottoDto);
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();

        return LottoInput.create(winningNumbers, bonusNumber, money);
    }

    private int getBonusNumber() {
        return view.inputBonusNumber();
    }

    private List<Integer> getWinningNumbers() {
        return view.inputWinningNumbers();
    }
}
