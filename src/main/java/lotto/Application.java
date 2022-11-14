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
            firstStep();
            printPurchaseResult();
            secondStep();

            managerService.judgeResult(user, manager);

            lastStep();
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputUtil.printEndProgram();
        }
    }

    private void firstStep() {
        userService.setInputMoney(user);
        managerService.changeLottos(user);
    }

    private void printPurchaseResult() {
        OutputUtil.printUserLottoCount(user);
        OutputUtil.printUserLottos(user);
    }

    private void secondStep() {
        managerService.setWinningNumber(manager);
        managerService.setBonusNumber(manager);
    }

    private void lastStep() {
        userService.calculateYield(user);
        OutputUtil.printResult(user);
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }
}
