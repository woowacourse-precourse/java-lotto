package lotto;

import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int amount = InputView.readBuyingAmount();
        String winningInputNumbers = InputView.readWinningNumbers();
        String winningBonusNumber = InputView.readBonusNumber();
        Player player = new Player(amount);
        OutputView.showLottoNumbers(player);

        WinningNumbers winningNumbers = new WinningNumbers(winningInputNumbers, winningBonusNumber);
        player.playTheLottery(winningNumbers);
        OutputView.showLotteryResults(player);
        OutputView.showLotteryYield(player);
    }
}
