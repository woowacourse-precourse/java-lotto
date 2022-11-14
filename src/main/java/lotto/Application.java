package lotto;

import lotto.domain.User;
import lotto.domain.WinningLotto;
import lotto.service.UserIOService;

public class Application {
    public static void main(String[] args) {

        User user = new User();
        user.buyLotto();
        user.printBoughtLotto();

        UserIOService ioService = new UserIOService();
        WinningLotto answer = new WinningLotto(ioService.scanWinningNumber());
        System.out.println(answer);
        

    }
}
