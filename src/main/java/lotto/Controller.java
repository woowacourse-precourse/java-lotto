package lotto;

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
}
