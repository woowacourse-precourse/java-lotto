package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.service.LottoInputNumbersService;
import lotto.service.LottoCalculateService;
import lotto.service.UserInputNumbersService;

public class LottoGameController {
    private final LottoInputNumbersService lottoInputNumbersService = new LottoInputNumbersService();
    private final UserInputNumbersService userInputNumbersService = new UserInputNumbersService();
    private final LottoCalculateService lottoCalculateService = new LottoCalculateService();


}
