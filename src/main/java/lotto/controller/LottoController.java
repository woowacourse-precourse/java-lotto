package lotto.controller;

import lotto.domian.Lotto;
import lotto.domian.User;
import lotto.service.CalculateUserCorrectLottoInfoService;
import lotto.service.UserInputWinningNumberService;
import lotto.service.UserLottoBuyingService;

public class LottoController {

    UserLottoBuyingService userLottoBuyingService = new UserLottoBuyingService();
    UserInputWinningNumberService userInputWinningNumberService = new UserInputWinningNumberService();
    CalculateUserCorrectLottoInfoService calculateUserCorrectLottoInfoService = new CalculateUserCorrectLottoInfoService();

    public void start() {
        User user = userLottoBuyingService.setUserInfo();
        Lotto lotto = userInputWinningNumberService.setWinningNumbersInfo();
        calculateUserCorrectLottoInfoService.calculateUserWinningInfo(lotto, user);
    }
}
