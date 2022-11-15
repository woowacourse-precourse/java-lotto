package lotto;


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
}
