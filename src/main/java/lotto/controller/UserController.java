package lotto.controller;

import lotto.domain.Lotto;
import lotto.repository.UserRepository;
import lotto.service.ExceptionService;
import lotto.service.RandomLottoService;
import lotto.service.UserService;
import lotto.view.GameProgressView;
import lotto.view.WinningStatsView;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    private static UserRepository userRepository = new UserRepository();
    private static UserService userService = new UserService();
    private static RandomLottoService randomLottoService = new RandomLottoService();
    private static GameProgressView gameProgressView = new GameProgressView();
    private static WinningStatsView winningStatsView = new WinningStatsView();
    private static ExceptionService exceptionService = new ExceptionService();

    public void savePurchaseAmount() {
        gameProgressView.showPurchaseMessage();
        String purchaseAmount = userService.enterPurchaseAmount();
        exceptionService.exceptionHandlingOfPurchaseAmount(purchaseAmount);
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

    public void enterWinningNumbersAndSave() {
        winningStatsView.showLineBreak();
        gameProgressView.showEnterWinningNumbersMessage();
        String winningNumbers = userService.enterWinningNumbers();
        exceptionService.exceptionHandlingOfWinningNumbers(winningNumbers);
        ArrayList<Integer> numbers = userService.convertWinningNumbers(winningNumbers);
        Lotto lotto = new Lotto(numbers);
        userRepository.setUserWinningNumbers(lotto);
    }

    public void enterBonusNumberAndSave() {
        winningStatsView.showLineBreak();
        gameProgressView.showEnterBonusNumberMessage();
        String bonusNumber = userService.enterBonusNumber();
        // TODO : 예외 처리 필요
        userRepository.setUserBonusNumber(Integer.parseInt(bonusNumber));
    }

    public void showWinningStatisticsAndSave() {
        winningStatsView.showLineBreak();
        winningStatsView.showWinningStatsMessage();
        winningStatsView.showContour();
        ArrayList<Integer> numberOfWinningTypes = userService.checkTheNumberOfWinsInAll(userRepository.getUser().getWinningNumbers(),
                userRepository.getUser().getLotties(),
                userRepository.getUser().getBonusNumber());
        winningStatsView.showWinning(numberOfWinningTypes);
        userRepository.setUserNumberOfWinningTypes(numberOfWinningTypes);
    }

    public void showRateOfReturnAndSave() {
        int prize = userService.calculateUserPrize(userRepository.getUser().getNumberOfWinningTypes());
        userRepository.setUserPrizeMoney(prize);
        String rateOfReturn = userService.calculateTheRateOfReturn(userRepository.getUser().getPrizeMoney(),
                userRepository.getUser().getPurchaseMoney());
        winningStatsView.showRateOfReturn(rateOfReturn);
    }
}
