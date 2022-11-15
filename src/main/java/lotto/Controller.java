package lotto;


import java.util.List;

public class Controller {
    private final Model model = new Model();
    private final View view = new View();
    private final ExceptionController exceptionController = new ExceptionController();
    public Controller() {
    }
    public void inputUserMoney() {
        String money = view.inputMoney();
        exceptionController.validateMoney(money);
        int moneyInt = Integer.parseInt(money);
        this.model.setUserMoney(moneyInt);
    }
    public void purchaseLotto() {
        this.model.generateLotto();
        this.view.printPurchase(this.model.getLottoList());
    }

    public void inputWinningNumber() {
        List<String> input = view.inputWinNumber();
        this.exceptionController.validateWinNumIsInt(input);
        this.model.setWinningLotto(input);
    }

    public void inputBonusNumber() {
        String input = this.view.inputBonus();
        this.exceptionController.validateBonus(input);
        this.model.setBonus(Integer.parseInt(input));
    }

    public void printStatistics() {
        this.model.compare();
        this.view.printStatistics(this.model.getSameNumbers());
    }

    public void printReturnRate() {
        this.model.calculateReturn();
        double returnRate = this.model.getReturnRate();
        this.view.printReturnRate(returnRate);
    }
}
