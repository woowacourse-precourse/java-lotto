package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.service.LottoCalculateService;
import lotto.service.LottoInputDataService;
import lotto.service.UserInputDataService;

public class LottoController {
    private final UserInputDataService userInputDataService = new UserInputDataService();
    private final LottoInputDataService lottoInputDataService = new LottoInputDataService();
    private final LottoCalculateService lottoCalculateService = new LottoCalculateService();

    public void start() {
        User user = setUserData();
        Lotto lotto = setLottoData();
        calculateLottoWinning(user, lotto);
    }

    public User setUserData() {
        return userInputDataService.inputUserData();
    }

    public Lotto setLottoData() {
        return lottoInputDataService.inputLottoData();
    }

    public void calculateLottoWinning(User user, Lotto lotto) {
        lottoCalculateService.calculateWinning(user, lotto);
    }
}
