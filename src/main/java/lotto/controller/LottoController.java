package lotto.controller;

import lotto.controller.dto.MoneyDto;
import lotto.controller.dto.WinningNumbersDto;
import lotto.domain.Lotto;
import lotto.service.LottoGameService;

public class LottoController {

    private final LottoGameService service;

    public LottoController(LottoGameService service) {
        this.service = service;
    }

    public void inputMoney(MoneyDto dto) {
        int money = dto.getMoney();
        service.buyLottos(money);
    }

    public String outputLottoSize() {
        return String.valueOf(service.getLottosSize());
    }

    public String outputLottos() {
        return service.getLottosToString();
    }

    public void inputWinningNumbers(WinningNumbersDto dto) {
        Lotto winningLotto = new Lotto(dto.getWinningNumber());
        int bonusNumber = dto.getBonusNumber();

    }
}
