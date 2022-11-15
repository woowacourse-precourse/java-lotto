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
        try {
            lottoPurchase();
            winningsNumberSetting();
            generateCalculationService();
            calculate();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    private void lottoPurchase() throws IllegalArgumentException {
        lottoPurchaseService.startLotto();
    }

    private void winningsNumberSetting() throws IllegalArgumentException {
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
