package lotto.controller;

import lotto.domain.Lotto;
import lotto.repository.UserRepository;
import lotto.service.RandomLottoService;
import lotto.service.UserService;
import lotto.view.GameProgressView;
import lotto.view.WinningStatsView;

import java.util.ArrayList;

public class UserController {
    private static UserRepository userRepository = new UserRepository();
    private static UserService userService = new UserService();
    private static RandomLottoService randomLottoService = new RandomLottoService();
    private static GameProgressView gameProgressView = new GameProgressView();
    private static WinningStatsView winningStatsView = new WinningStatsView();

    public void savePurchaseAmount() {
        gameProgressView.showPurchaseMessage();
        String purchaseAmount = userService.enterPurchaseAmount();
        //TODO : 예외 처리 필요
        userRepository.setUserPurchaseMoney(Integer.parseInt(purchaseAmount));
        userRepository.setUserNumberOfLotties(userService.findTheNumberOfLotteryTicketsPurchased(purchaseAmount));
    }

    public void showPurchaseInfo() {
        winningStatsView.showLineBreak();
        gameProgressView.showCountMessage(userRepository.getUser().getTotalNumberOflotties());
    }

    public void randomLotteryIssuanceAndShow() {
        ArrayList<Lotto> lotties = randomLottoService.randomLotteryGeneration(userRepository.getUser().getTotalNumberOflotties());
        userRepository.setUserLotties(lotties);
        gameProgressView.showBuyLottery(lotties);
    }
}
