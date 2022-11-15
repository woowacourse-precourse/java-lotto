package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Map;

public class GameManagerController {
    public static void play() {
        try {
            User user = getUserLotto();
            WinningLotto winningLotto = getWinningLotto();
            getResult(user, winningLotto);
        } catch (IllegalArgumentException error) {
            Error.printErrorMessage(error.getMessage());
        }
    }

    public static User getUserLotto() {
        InputView.printPurchasingAmount();
        User user = new User(Console.readLine());
        OutputView.printLottos(user.getLottoAmount(), user.getLottos());
        return user;
    }

    public static WinningLotto getWinningLotto() {
        InputView.printLottoNumbers();
        WinningLotto winningLotto = new WinningLotto(Console.readLine());
        InputView.printLottoBonusNumber();
        winningLotto.setBonusNumber(Console.readLine());
        return winningLotto;
    }

    public static void getResult(User user, WinningLotto winningLotto) {
        Comparison.createResult(user, winningLotto);
        Map<Comparison.Result, Integer> results = Comparison.getResults();
        OutputView.printCountResult(results);
        OutputView.printStatisticResult(Calculator.getProfit(results, user.getPurchasingAmount()));
    }
}
