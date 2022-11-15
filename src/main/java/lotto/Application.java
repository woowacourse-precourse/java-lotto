package lotto;

import lotto.domain.User;
import lotto.domain.WinningLotto;
import lotto.service.UserService;
import lotto.service.WinningLottoService;

public class Application {
    public static void main(String[] args) {
        try {
            User user = UserService.getUser();
            WinningLotto winningLotto = WinningLottoService.getWinningLotto();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
