package lotto;

import lotto.domain.User;
import lotto.domain.WinningLotto;
import lotto.service.UserService;
import lotto.service.WinningLottoService;

public class Application {
    private static final UserService userService = new UserService();
    private static final WinningLottoService winningLottoService = new WinningLottoService();

    public static void main(String[] args) {

        User user = userService.buyLotto();
        userService.printBoughtLotto(user);
        WinningLotto winningLotto = winningLottoService.scanWinningNums();
        System.out.println(winningLotto);
    }
}
