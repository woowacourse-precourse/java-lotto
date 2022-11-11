package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.service.LottoCalculateService;
import lotto.service.LottoInputDataService;
import lotto.service.UserInputDataService;

public class LottoController {

    public void start() {
        User user = setUserData();
        Lotto lotto = setLottoData();
        calculateLottoWinning(user, lotto);
    }

    public User setUserData() {
        UserInputDataService userInputDataService = new UserInputDataService();
        return userInputDataService.inputUserData();
    }

    public Lotto setLottoData() {
        LottoInputDataService lottoInputDataService = new LottoInputDataService();
        return lottoInputDataService.inputLottoData();
    }

    public void calculateLottoWinning(User user, Lotto lotto) {
        LottoCalculateService lottoCalculateService = new LottoCalculateService();
        lottoCalculateService.calculateWinning(user, lotto);
    }
}
