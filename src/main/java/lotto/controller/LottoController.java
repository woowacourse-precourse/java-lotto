package lotto.controller;

import lotto.domain.User;
import lotto.service.LottoPurchaseService;
import lotto.service.WinningsCalculationService;
import lotto.service.WinningsSettingService;

import java.util.List;

public class LottoController {

    private final LottoPurchaseService lottoPurchaseService = new LottoPurchaseService();

    private final WinningsSettingService winningsSettingService = new WinningsSettingService();

    private WinningsCalculationService winningsCalculationService;

    public void run() {
        lottoPurchase();
        winningsNumberSetting();
        generateCalculationService();
        calculate();
    }

    private void lottoPurchase() {
        lottoPurchaseService.startLotto();
    }

    private void winningsNumberSetting() {
        winningsSettingService.settingWinningsInfo();
    }

    private void calculate() {
        winningsCalculationService.winningHistoryCalculation();
    }

    private void generateCalculationService() {
        User user = lottoPurchaseService.getUser();
        List<Integer> winningsNumber = winningsSettingService.getWinningsNumber();
        Integer bonusNumber = winningsSettingService.getBonusNumber();

        winningsCalculationService = new WinningsCalculationService(user, winningsNumber, bonusNumber);
    }

}
