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

    public List<Lotto> generateLottos() {
        String balance = ui.inputBalance();
        int lottoAmount = service.getLottoAmount(balance);

        List<Lotto> lottos = service.generateLottos(lottoAmount);
        ui.printLottos(lottos);

        return lottos;
    }

    public void calculateProfit(List<Lotto> lottos, List<Integer> matchNumbers, int bonusNumber) {
        int[] rewards = service.calculateRewards(lottos, matchNumbers, bonusNumber);
        ui.printInfo(rewards);

        double profitRate = service.getProfitRate(rewards, lottos.size());
        ui.printProfitRate(profitRate);
    }

    public List<Integer> getMatchNumbers() {
        String inputMatchNumbers = ui.inputMatchNumbers();
        List<Integer> matchNumbers = service.getMatchNumbers(inputMatchNumbers);

        return matchNumbers;
    }

    public int getBonusNumber(List<Integer> matchNumbers) {
        String inputBonusNumber = ui.inputBonusNumber();
        int bonusNumber = service.getBonusNumber(inputBonusNumber, matchNumbers);

        return bonusNumber;
    }

    public void start() throws IllegalArgumentException {
        List<Lotto> lottos = generateLottos();

        List<Integer> matchNumbers = getMatchNumbers();
        int bonusNumber = getBonusNumber(matchNumbers);

        calculateProfit(lottos, matchNumbers, bonusNumber);
    }
}
