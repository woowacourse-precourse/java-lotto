package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.RankController;
import lotto.controller.UserController;
import lotto.domain.user.User;
import lotto.view.RankingView;
import lotto.view.Store;

public class Application {
    public static void main(String[] args) {
        LottoConfig lottoConfig = new LottoConfig();

        Store store = lottoConfig.store();
        RankingView rankingView = lottoConfig.rankingView();
        UserController userController = lottoConfig.userController();
        RankController rankController = lottoConfig.rankController();

        startLottoGame(store, rankingView, userController, rankController);
    }

    private static void startLottoGame(Store store, RankingView rankingView,
                                       UserController userController,
                                       RankController rankController) {
        try{
            User user = buyLotto(store, userController);
            drawLotto(rankingView, rankController, user);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    // 로또 구매
    private static User buyLotto(Store store, UserController userController) {
        System.out.println(store.sellingLotto());
        User user = new User(Console.readLine());

        System.out.println(userController.buyLotto(user));
        return user;
    }

    // 로또 추첨
    private static void drawLotto(RankingView rankingView, RankController rankController, User user) {
        System.out.println(rankingView.getWinningNumber());
        String winningNumber = Console.readLine();

        System.out.println(rankingView.getBonusNumber());
        String bonus = Console.readLine();

        System.out.println(rankController.statistics(user, winningNumber, bonus));
    }
}
