package lotto;

import User.User;
import YieldMachine.YieldMachine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
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
