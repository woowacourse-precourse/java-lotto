package lotto;

import lotto.domain.Result;
import lotto.domain.User;
import lotto.domain.WinningLotto;
import lotto.service.ResultService;
import lotto.service.UserService;
import lotto.service.WinningLottoService;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        try {
            User user = UserService.getUser();
            WinningLotto winningLotto = WinningLottoService.getWinningLotto();
            Result result = ResultService.addRankResult(user, winningLotto);
            OutputView.printResult(user, result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
