package lotto.controller;

import lotto.controller.dto.MoneyDto;
import lotto.controller.dto.WinningNumbersDto;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.Lottos;
import lotto.service.LottoGameService;

import java.util.EnumMap;

public class LottoController {

    private static final int PERCENT = 100;

    private final LottoGameService service;

    public LottoController(LottoGameService service) {
        this.service = service;
    }

    public void inputMoney(MoneyDto dto) {
        int money = dto.getMoney();
        service.buyLottos(money);
    }

    public Lottos outputLottos() {
        return service.findLottos();
    }

    public void inputWinningNumbers(WinningNumbersDto dto) {
        Lotto winningLotto = new Lotto(dto.getWinningNumber());
        int bonusNumber = dto.getBonusNumber();
        service.checkWinningNumbers(winningLotto, bonusNumber);
    }

    public EnumMap<LottoRank, Integer> outputRanks() {
        return service.showLottosRank();
    }

    public double getProfitRate(EnumMap<LottoRank, Integer> lottoRanks) {
        return service.showProfitRate(lottoRanks) * PERCENT;
    }
}
