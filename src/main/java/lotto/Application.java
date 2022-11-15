package lotto;

import lotto.domain.Statistics;
import lotto.domain.User;
import lotto.domain.WinningLotto;
import lotto.service.StatisticsService;
import lotto.service.UserService;
import lotto.service.WinningLottoService;

public class Application {
    private static final UserService userService = new UserService();
    private static final WinningLottoService winningLottoService = new WinningLottoService();
    private static final StatisticsService staticsService = new StatisticsService();

    public static void main(String[] args) {
        try {
            User user = userService.buyLotto();
            userService.printBoughtLottos(user);
            WinningLotto winningLotto = winningLottoService.scanWinningNums();
            Statistics statistics = staticsService.calculateRating(user, winningLotto);
            staticsService.printTotality(statistics);
            staticsService.printProfit(statistics, user);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
