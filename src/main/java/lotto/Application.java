package lotto;

import lotto.user.User;
import lotto.yieldMachine.YieldMachine;

public class Application {
    public static void main(String[] args) {
        try {
            User user = new User();
            user.buyLottos();
            user.printLottos();
            YieldMachine yieldMachine = new YieldMachine();
            yieldMachine.run(user);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
