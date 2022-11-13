package lotto;

import java.util.List;

public class Controller {
    private final Model model = new Model();
    private final View view = new View();
    private final ExceptionController exceptionController = new ExceptionController();
    public Controller() {
    }

    /**
     * input money value by user and serve to Model.setUserMoney
     */
    public void inputUserMoney() {
        String money = view.inputMoney();
        exceptionController.validateMoney(money);
        int moneyInt = Integer.parseInt(money);
        this.model.setUserMoney(moneyInt);
    }

    /**
     * generate lotto numbers and print that
     */
    public void purchaseLotto() {
        this.model.generateLotto();
        this.view.printPurchase(this.model.getLottoList());
    }

    /**
     * input winning lotto numbers
     */
    public void inputWinningNumber() {
        List<String> input = view.inputWinNumber();
        this.exceptionController.validateWinNumIsInt(input);
        this.model.setWinningLotto(input);
    }

    /**
     * input bonus number
     */
    public void inputBonusNumber() {
        String input = this.view.inputBonus();
        this.exceptionController.validateBonus(input);
        this.model.setBonus(Integer.parseInt(input));
    }

    /**
     * compare numbers and print statistics
     */
    public void printStatistics() {
        this.model.compare();
        this.view.printStatistic();
    }

    /**
     * calculate rate of return and print that
     */
    public void printReturnRate() {
        this.model.calculateReturn();
        double returnRate = this.model.getReturnRate();
        this.view.printReturnRate(returnRate);
    }
}
