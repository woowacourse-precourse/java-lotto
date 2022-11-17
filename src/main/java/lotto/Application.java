package lotto;

import lotto.domain.Manager;
import lotto.domain.User;
import lotto.service.ManagerService;
import lotto.service.UserService;
import lotto.util.OutputUtil;

public class Application {

    UserService userService = new UserService();
    ManagerService managerService = new ManagerService();
    User user = new User();
    Manager manager = new Manager();

    private void run() {
        try {
            userService.setInputMoney(user);
            managerService.changeToLottos(user);

            OutputUtil.printUserLottoCount(user);
            OutputUtil.printUserLottos(user);

            managerService.setWinningNumber(manager);
            managerService.setBonusNumber(manager);

            managerService.judgeResult(user, manager);
            userService.calculateYield(user);
            OutputUtil.printResult(user);
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputUtil.printEndProgram();
        }
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }
}
