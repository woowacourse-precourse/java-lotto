package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoService;
import lotto.ui.Ui;

public class Game {
    private final Ui ui;
    private final LottoService service;

    public Game(Ui ui, LottoService service) {
        this.ui = ui;
        this.service = service;
    }

    public void start() throws IllegalArgumentException {
        String balance = ui.inputBalance();
        int lottoAmount = service.getLottoAmount(balance);

        List<Lotto> lottos = service.generateLottos(lottoAmount);
        ui.printLottos(lottos);

        String inputMatchNumbers = ui.inputMatchNumbers();
        List<Integer> matchNumbers = service.getMatchNumbers(inputMatchNumbers);
        String inputBonusNumber = ui.inputBonusNumber();
        int bonusNumber = service.getBonusNumber(inputBonusNumber, matchNumbers);

        int[] rewards = service.calculateRewards(lottos, matchNumbers, bonusNumber);
        ui.printInfo(rewards);
    }
}
