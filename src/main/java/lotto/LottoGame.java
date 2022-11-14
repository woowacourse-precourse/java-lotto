package lotto;

import lotto.domain.Money;
import lotto.service.LottoService;
import lotto.view.LottoDto;
import lotto.view.LottoInputDto;
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
            LottoInputDto lottoInputDto = getLottoInputDto();
            PrizeDto prizeDto = lottoService.calcWinningResult(lottoInputDto);
            view.printPrize(prizeDto);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public LottoInputDto getLottoInputDto() {
        Money money = Money.of(view.inputMoney());
        LottoDto lottoDto = lottoService.createLottos(money);
        view.printBuyLotto(lottoDto);
        LottoInputDto lottoInputDto = view.inputNumbers();
        lottoInputDto.setMoney(money);
        return lottoInputDto;
    }
}
