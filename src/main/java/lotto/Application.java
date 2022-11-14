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
            firstPhase();
            printPurchaseResult();
            secondPhase();
            lastPhase();
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputUtil.printEndProgram();
        }
    }

    private void firstPhase() {
        userService.setInputMoney(user);
        managerService.changeLottos(user);
    }

    private void printPurchaseResult() {
        OutputUtil.printUserLottoCount(user);
        OutputUtil.printUserLottos(user);
    }

    private void secondPhase() {
        managerService.setWinningNumber(manager);
        managerService.setBonusNumber(manager);
    }

    private void lastPhase() {
        managerService.judgeResult(user, manager);
        userService.calculateYield(user);
        OutputUtil.printResult(user);
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }
}
