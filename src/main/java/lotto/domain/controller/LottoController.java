package lotto.domain.controller;

import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.service.LottoCalculateService;
import lotto.service.LottoInputDataService;
import lotto.service.UserInputDataService;

public class LottoController {
    private User user;
    private Lotto lotto;
    private LottoInputDataService lottoInputDataService = new LottoInputDataService();
    private UserInputDataService userInputDataService = new UserInputDataService();
    private LottoCalculateService lottoCalculateService = new LottoCalculateService();

    public void start() {
        setUserData();
        setLottoData();
    }

    public void setUserData() {
        user = userInputDataService.inputUserData();
    }

    public void setLottoData() {
        lotto = lottoInputDataService.inputLottoData();
    }
}
